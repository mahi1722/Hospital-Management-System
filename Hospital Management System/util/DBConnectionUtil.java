package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("resources/db.properties");
            props.load(fis);

            String connectionString = props.getProperty("connectionString");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
