package Lab8;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.sql.*;
public class DBProps {
    public static Connection con;
    public static Statement st;
    public static ResultSet rs;
    public static String driver;
    public static String url;
    public static String uname;
    public static String pwd;
    static {
        try{
            Properties props = new Properties();
            InputStream input = new FileInputStream("D:\\261100610017\\CAWJ\\src\\Lab8\\db.properties");
            props.load(input);

            driver = props.getProperty("db.driver");
            System.out.println(driver);
            url = props.getProperty("db.url");
            uname = props.getProperty("db.uname");
            pwd = props.getProperty("db.pwd");


        } catch (Exception e) {
            System.out.println("EXCEPTION :"+e);
        }
    }

    public static void loadDriver(){
        try {
            Class.forName(driver);
        System.out.println("DRIVER LOADED SUCCESSFULLY");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR CAUGHT : "+e);
        }
    }
    public static void getConnection(){
        try {
            con = DriverManager.getConnection(url,uname,pwd);
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("ERROR CAUGHT"+e);
        }
    }

    public static void generateStatement(){
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("STATEMENT GENERATED SUCCESSFULLY");
        } catch (SQLException e) {
            System.out.println("ERROR CAUGHT"+e);
        }
    }

    public static void retrieveRecords(){
        try {
            rs = st.executeQuery("SELECT  * from login");
            while(rs.next()){
                System.out.println("NAME : "+rs.getString(1)+"\t"+"PWD : "+rs.getString(2));
            }
        }
        catch (SQLException e) {
            System.out.println("ERROR CAUGHT : "+e);
        }
    }

    public static void closeObjects(){
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String [] args){
        System.out.println("DRIVER : "+driver+"\nURL : "+url+"\nUSERNAME : "+uname+"\nPASSWORD : "+pwd);
        loadDriver();
        getConnection();
        generateStatement();
        retrieveRecords();
        closeObjects();
    }

}
