package DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private final String connectURL = "jdbc:postgresql://localhost:5432/postgres";
    private Connection conn = null;
    private Properties properties;

    public DBConnection(){
        properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "goku123");
    }
    public Connection getConnection(){
        try{
            conn = DriverManager.getConnection(connectURL, properties);
        } catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return conn;
    }
}
