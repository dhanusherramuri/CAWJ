package Lab9;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;

public class EmployeeDAO {
    private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
    private Connection con = null;
    private PreparedStatement ps = null;

    public void prepareDAO(){
        try{
            con = DBConnection.getConnection();
            String Query = "INSERT INTO employee (id , name, salary) VALUES (? , ? , ?)";
            ps = con.prepareStatement(Query);
            FileHandler fh = new FileHandler("employeeApp.log" , true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void insertEMP(int id, String name, int sal){
        try{
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3, sal);

            int rows = ps.executeUpdate();
            logger.info(rows + "employee(s) inserted successfully");

        }
        catch(Exception e){
            logger.log(Level.SEVERE, "ERROR INSERTING EMPLOYEE ",e);
        }
    }
    public void fetchDAO(){
        try{
            String Query = "SELECT * FROM employee";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Query);
            while(rs.next()){
//                System.out.println("ID =  "+rs.getInt(1)+" NAME = "+rs.getString(2)+"SALARY = "+rs.getInt(3));
                logger.info("ID =  "+rs.getInt(1)+" NAME = "+rs.getString(2)+" SALARY = "+rs.getInt(3));

            }
        }
        catch(Exception e){
//            System.out.println(e);
            logger.log(Level.SEVERE,"EXECEPTION CAUGHT "+e);
        }
    }
}
