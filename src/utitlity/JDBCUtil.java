package utitlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private JDBCUtil() {
    }
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getJDBCconnection() throws SQLException, IOException {
        FileInputStream fis=new FileInputStream("src\\properties\\DB.properties");
        Properties properties=new Properties();
        properties.load(fis);
        return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));

    }
}
