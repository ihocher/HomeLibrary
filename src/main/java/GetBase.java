import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetBase extends Thread {



    //Need to change sql request for more appropriate variant
    private volatile String sqlShort;
    private String sqlFull ;
    private ArrayList<BookDetails> bd;

    public void setSqlShort(String sqlShort) {
        this.sqlShort = sqlShort;
    }

    GetBase(String sqlShort){
        this.sqlShort = sqlShort;
    }

    public void run(){

        try {
            getBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //Add exception to each method where it needed to catch all of it
    public void getBase() throws SQLException {
        DBconnection dbCon = new DBconnection();

        try {
            dbCon.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement myStmt = dbCon.getStatement();
        sqlFull = "select *from mydbtest.books where name = " + "'" + sqlShort + "'";
        //System.out.println("SqlShort: " + sqlShort);
        //System.out.println("SqlFull: " + sqlFull);
        ResultSet rs = myStmt.executeQuery(sqlFull);

        bd = new ArrayList<BookDetails>();
        BookDetails bookD;
        while (rs.next()) {

            bookD =new BookDetails(rs.getString("name" ),rs.getString("author"),rs.getString("place"));
            bd.add(bookD);
            }

        //Check changes of array
        System.out.println("Array size is " + bd.size());

        dbCon.closeConnection();
    }


    public ArrayList<BookDetails> getBd() {
        return bd;
    }

}
