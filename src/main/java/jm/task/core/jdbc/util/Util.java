package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {
    private static final String URL_KEY = "connection.url";
    private static final String USERNAME_KEY = "connection.username";
    private static final String PASSWORD_KEY = "connection.password";

    private Util() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.getProperty(URL_KEY),
                    PropertiesUtil.getProperty(USERNAME_KEY),
                    PropertiesUtil.getProperty(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}