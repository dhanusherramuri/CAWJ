package Lab9;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static Connection conn = null;

    static {
        try {
            String path = "./src/db.properties";
            Properties props = new Properties();
            FileInputStream input = new FileInputStream(path);
            props.load(input);

            String driver = props.getProperty("db.driver");
            String url = props.getProperty("db.url");
            String uname = props.getProperty("db.uname");
            String pwd = props.getProperty("db.pwd");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, uname, pwd);

            logger.info("Database Connection establish successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "DATABASE CONNECTION FAILED : ", e);
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
