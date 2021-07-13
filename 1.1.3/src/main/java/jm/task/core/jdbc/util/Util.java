package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String userName = "root";
    private static String password = "root";
    private static String connectUrl = "jdbc:mysql://localhost:3306/users?useSSL=false";

    public static Connection connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(connectUrl, userName, password);
        return connection;

    }
}