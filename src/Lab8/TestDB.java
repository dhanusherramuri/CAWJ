package Lab8;
import java.sql.SQLException;
import java.util.*;
public class TestDB {
    static Scanner r = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the UserName :");
        String uname = r.next();
        System.out.println("Enter the Password : ");
        String pwd = r.next();
        DBClass.loadDriver("com.mysql.jdbc.Driver");
        DBClass.createConnection("jdbc:mysql://localhost:3306/testdb",uname,pwd);
        DBClass.generateStatement();
        DBClass.getStatement();
        System.out.println("ENTER THE QUERY : ");
        r.nextLine();
        String query = r.nextLine();
        DBClass.retrieveRecord(query);

            try {
                while (DBClass.rs.next()) {
                    System.out.println("Name : " + DBClass.rs.getString(1) + "\t" + "Password : " + DBClass.rs.getString(2));
                }
            }
            catch (SQLException e) {
                System.out.println("EXception Caught : "+e);
            }
        DBClass.closeObjects();

    }
}
