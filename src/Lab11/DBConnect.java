
package Lab11;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.logging.*;

public class DBConnect {

    private static final Logger Logg =
            Logger.getLogger(DBConnect.class.getName());

    private static Connection conn = null;

    static {
        Properties prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(
                    "D:\\261100610017\\CAWJ\\src\\db.properties"
            );

            prop.load(fis);
            fis.close();

            String driver = prop.getProperty("db.driver");
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.uname");
            String password = prop.getProperty("db.pwd");

            Class.forName(driver);

            conn = DriverManager.getConnection(
                    url, username, password
            );

            Logg.info("Connected to database successfully");

        } catch (Exception e) {
            Logg.log(Level.SEVERE, "Database connection failed", e);
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
