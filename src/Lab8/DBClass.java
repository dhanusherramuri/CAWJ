package Lab8;

import java.sql.*;

public class DBClass {
    private static Connection con;
    private static Statement st;
    public static ResultSet rs;

    public static void loadDriver(String ClassName){
        try{
            Class.forName(ClassName);
            System.out.println("LOADED DRIVER SUCCESSFULLY");
        }
        catch(Exception e){
            System.out.println("ERROR CAUGHT : "+e);
        }
    }

    public static void createConnection(String url, String uname, String pwd){
        try {
            con = DriverManager.getConnection(url,uname,pwd);
            System.out.println("CONNECTION ESTABLISHED : "+con);
        } catch (SQLException e) {
            System.out.println("ERROR CAUGHT : "+e);
        }
    }

    public static void generateStatement(){
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("STATEMENT CREATED : "+st);
        } catch (SQLException e) {
            System.out.println("EXCEPTION CAUGHT : "+e);
        }
    }
    public static void getStatement(){
        System.out.println("Statement :"+st);
    }

    public static void retrieveRecord(String query){
        try {
            rs = st.executeQuery(query);
//            rs = st.executeQuery("SELECT  * from login");
//            while(rs.next()){
//                System.out.print("\nNAME : "+rs.getString(1)+"\t"+"Password : "+rs.getString(2));
//            }
        } catch (SQLException e) {
           System.out.println("EXCEPTION CAUGHT : "+e);
        }
    }

    public static void closeObjects(){
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("EXCEPTION CAUGHT :"+e);
        }

    }

//    public static void main(String [] args){
//        loadDriver();
//        createConnection();
//        generateStatement();
//        display();
//        closeObjects();
//
//    }
}
