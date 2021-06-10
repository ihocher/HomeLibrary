import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetBase extends Thread {


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

    public void getBase() throws SQLException {
        DBconnection dbCon = new DBconnection();

        try {
            dbCon.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement myStmt = dbCon.getStatement();
        sqlFull = "select *from mydbtest.books where name = " + "'" + sqlShort + "'";
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
