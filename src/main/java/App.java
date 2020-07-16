import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Window win = new Window();
        /*
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydbtest";
        String urlfixed = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "rootpass";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            Statement myStmt = connection.createStatement();
            String sql = "select*from mydbtest.users;";
            ResultSet rs = myStmt.executeQuery(sql);

            while(rs.next())
                System.out.println(rs.getString("name"));


        }
        */


        /*
        DBconnection dbCon = new DBconnection();
        dbCon.connect();
        Statement myStmt = dbCon.getStatement();


        MyListener lis = new MyListener();
        win.addListener(lis);

        String req = "";
        req = lis.getString();


        String sql = "select *from mydbtest.books where name = 'Red and black'";
        ResultSet rs = myStmt.executeQuery(sql);

        while (rs.next()) {
            System.out.print(rs.getString("name" ) + rs.getString("author") + rs.getString("place"));

        }

         */

        /*
        //GetBase part
        GetBase gb = new GetBase();
        gb.run();
        gb.join();

        ArrayList<BookDetails> bd = gb.getBd();


            System.out.println(bd.get(0));

        */

        //Main code

        MyListener mLis = new MyListener();
        win.addListener(mLis);
        try{
        mLis.start();
        mLis.join();}
        catch(Exception e){

        }

        long startTime = System.currentTimeMillis();
        GetBase base = new GetBase(mLis.getString());
        try{
        base.start();
        base.join();}
        catch(Exception e){

        }

        ArrayList<BookDetails> arrBd = base.getBd();
        if(arrBd.size()==0){
            win.setResult("There is no such book.");
        }else{
        win.setResult(String.valueOf(arrBd.get(0)));}
        long endTime = System.currentTimeMillis();

        System.out.println("Time for getting info from base: " + (endTime - startTime));

        System.out.println("Checking...");
        System.out.println(mLis.getString());






        /*
        GetBase base = new GetBase(mLis.getString());
        ArrayList<BookDetails> arrBd = base.getBd();
        win.setResult(String.valueOf(arrBd.get(0)));
        */

        //Checking of GetBase getBase function
        /*String st = "Red and black";
        DBconnection dbCon = new DBconnection();

        try {
            dbCon.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement myStmt = dbCon.getStatement();
        ResultSet rs = null;
        try {
            rs = myStmt.executeQuery("select *from mydbtest.books where name = '" + st + "'");
        } catch(Exception e){
            System.out.println("Exception happend in the process of getting result from bd " + e);
        }

        ArrayList<BookDetails> bd = new ArrayList<BookDetails>();
        BookDetails bookD;
        try {
            while (rs.next()) {

                bookD = new BookDetails(rs.getString("name"), rs.getString("author"), rs.getString("place"));
                bd.add(bookD);
            }
        }catch(Exception e){
            System.out.println("Exception happend in while block ");
        }
        //Check change of array
        System.out.println("Array size is " + bd.size());

        try {
            dbCon.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */



    }


}
