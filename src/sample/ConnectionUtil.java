package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/coursesWithDate?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    Connection conn = null;
    public static Connection connDB(){
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
//        if (DB_USER.equals() &&  DB_PASSWORD.isEmpty()) {
//            System.out.println("Voshli");
//        }else  if (!DB_USER.isEmpty()  && !DB_PASSWORD.isEmpty()) {
//            System.out.println("Not Voshli");
    }
}

