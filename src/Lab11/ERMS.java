package Lab11;
import java.sql.*;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ERMS {
    private static Logger logg = Logger.getLogger(ERMS.class.getName());
    private static PreparedStatement insert_pst = null;
    private static PreparedStatement insert_pst_Subj = null;
    private static PreparedStatement insert_pst_exam = null;
    private static PreparedStatement update_pst_students = null;
    private static Connection conn = null;
    Scanner r = new Scanner(System.in);
    public void PrepareERMS(){
        try{
            FileHandler fh = new FileHandler("ERMS.log", true);
            fh.setFormatter(new SimpleFormatter());
            logg.addHandler(fh);
        conn = DBConnect.getConnection();
        String query_student = "INSERT INTO Student VALUES (?,?,?,?,?)";
        String query_subj = "INSERT INTO Subject VALUES (?,?,?,?)";
        String query_exam = "INSERT INTO Examination VALUES (?,?,?,?)";
        String query_update_marks = " UPDATE Result SET Marks_Obtained = ?, Grade = ? WHERE Exam_ID = ? AND Student_ID = ?";
        insert_pst = conn.prepareStatement(query_student);
        insert_pst_Subj = conn.prepareStatement(query_subj);
        insert_pst_exam = conn.prepareStatement(query_exam);
        update_pst_students = conn.prepareStatement(query_update_marks);
        }
        catch (Exception e){
            logg.info(e.getMessage());
        }

    }
    public void InsertStudent(){
        System.out.println("Enter Student ID");
        String id=r.nextLine();
        System.out.println("Enter Student Name");
        String name=r.nextLine();
        System.out.println("Enter Student Program");
        String program=r.nextLine();
        System.out.println("Enter Semester");
        int sem =r.nextInt();
        r.nextLine();
        System.out.println("Enter Email");
        String email=r.nextLine();
        try{
        insert_pst.setString(1,id);
        insert_pst.setString(2,name);
        insert_pst.setString(3,program);
        insert_pst.setInt(4,sem);
        insert_pst.setString(5,email);
        insert_pst.execute();
        logg.info("INSERTED ROWS SUCCESSFULLY");
        }
        catch(Exception e){
            logg.info(e.getMessage());
        }
    }
    public void InsertSubject(){
        System.out.println("Enter Subject ID");
        String id=r.nextLine();
        System.out.println("Enter Subject Name");
        String name=r.nextLine();
        System.out.println("Enter Subject Credits");
        int credits=r.nextInt();
        System.out.println("Enter Subject Semester");
        int sem=r.nextInt();
        try{
            insert_pst_Subj.setString(1,id);
            insert_pst_Subj.setString(2,name);
            insert_pst_Subj.setInt(3,sem);
            insert_pst_Subj.setInt(4,credits);
            insert_pst_Subj.execute();
            logg.info("INSERTED ROWS SUCCESSFULLY");
        }
        catch(Exception e){
            logg.info(e.getMessage());
        }
    }

    public void InsertExam(){
        System.out.println("Enter Examination ID");
        String id=r.nextLine();
        System.out.println("Enter Subject Id");
        String name=r.nextLine();
        System.out.println("Enter Examination Date");
        String exam=r.nextLine();
        System.out.println("Enter Max Marks");
        Double marks=r.nextDouble();
        try{
        insert_pst_exam.setString(1,id);
        insert_pst_exam.setString(2,name);
        insert_pst_exam.setString(3,exam);
        insert_pst_exam.setDouble(4,marks);
        insert_pst_exam.execute();
        logg.info("INSERTED ROWS SUCCESSFULLY");
        }
        catch(Exception e){
            logg.info(e.getMessage());
        }
    }
    
    public void updateResult(){
        System.out.println("Enter Student ID");
        String id=r.nextLine();
        System.out.println("Enter Examination ID");
        String exam=r.nextLine();
        System.out.println("Enter the updated Marks");
        Double marks=r.nextDouble();
        r.nextLine();
        System.out.println("Enter the updated grade");
        String grade=r.nextLine();
        try{
            update_pst_students.setString(4,id);
            update_pst_students.setString(3,exam);
            update_pst_students.setDouble(1,marks);
            update_pst_students.setString(2,grade);
            update_pst_students.executeUpdate();
            logg.info("UPDATED ROWS SUCCESSFULLY");

        }
        catch(Exception e){
            logg.info(e.getMessage());
        }
    }


}
