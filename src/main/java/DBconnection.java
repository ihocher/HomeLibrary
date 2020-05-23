import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL =
            "jdbc:mysql://localhost:3306/mydbtest";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "rootpass";

    private Connection conn = null;

    private Statement stmt = null;

    public void connect() throws SQLException, Exception {
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        stmt = conn.createStatement();
    }

    public void closeConnection() throws SQLException {
        stmt.close();
        conn.close();
    }

    public Statement getStatement(){
        return stmt;
    }

    public Connection getConnection(){
        return conn;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}
