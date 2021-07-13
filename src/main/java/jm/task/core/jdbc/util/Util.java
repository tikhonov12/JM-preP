package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String userName = "root";
    private static String password = "root";
    private static String connectUrl = "jdbc:mysql://localhost:3306/users?useSSL=false";
    public Util(){}
public static Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(connectUrl, userName, password);
        return connection;
    }
}