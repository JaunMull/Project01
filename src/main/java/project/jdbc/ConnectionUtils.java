package project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection createConnection(){
        String url = System.getenv("Project_1");

        try {
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
