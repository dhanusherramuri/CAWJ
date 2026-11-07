
package Lab11;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class ERMS {

    private static Logger logg = Logger.getLogger(ERMS.class.getName());

    private static PreparedStatement insert_pst = null;
    private static PreparedStatement insert_pst_Subj = null;
    private static PreparedStatement insert_pst_exam = null;
    private static PreparedStatement insert_pst_result = null;

    private static PreparedStatement update_pst_students = null;
    private static PreparedStatement update_pst_student = null;
    private static PreparedStatement update_pst_subject = null;
    private static PreparedStatement update_pst_exam = null;

    private static PreparedStatement avg_pst = null;
    private static PreparedStatement highest_pst = null;

    private static Connection conn = null;

    Scanner r = new Scanner(System.in);

    public void PrepareERMS() {

        try {

            FileHandler fh = new FileHandler("ERMS.log", true);
            fh.setFormatter(new SimpleFormatter());
            logg.addHandler(fh);

            conn = DBConnect.getConnection();

            if (conn == null) {
                throw new SQLException("Database connection failed");
            }

            String query_student =
                    "INSERT INTO Student VALUES (?,?,?,?,?)";

            String query_subj =
                    "INSERT INTO Subject VALUES (?,?,?,?)";

            String query_exam =
                    "INSERT INTO Examination VALUES (?,?,?,?)";

            String query_result =
                    "INSERT INTO Result VALUES (?,?,?,?)";

            String query_update_marks =
                    "UPDATE Result SET Marks_Obtained=?, Grade=? WHERE Exam_ID=? AND Student_ID=?";

            String query_update_student =
                    "UPDATE Student SET Student_Name=?, Program=?, Semester=?, Email=? WHERE Student_ID=?";

            String query_update_subject =
                    "UPDATE Subject SET Subject_Name=?, Semester=?, Credits=? WHERE Subject_ID=?";

            String query_update_exam =
                    "UPDATE Examination SET Subject_ID=?, Exam_Date=?, Max_Marks=? WHERE Exam_ID=?";

            String query_average =
                    "SELECT s.Subject_ID, s.Subject_Name, AVG(r.Marks_Obtained) AS Average_Marks " +
                            "FROM Subject s " +
                            "JOIN Examination e ON s.Subject_ID=e.Subject_ID " +
                            "JOIN Result r ON e.Exam_ID=r.Exam_ID " +
                            "GROUP BY s.Subject_ID, s.Subject_Name";

            String query_highest =
                    "SELECT s.Subject_ID, s.Subject_Name, st.Student_ID, st.Student_Name, r.Marks_Obtained " +
                            "FROM Student st " +
                            "JOIN Result r ON st.Student_ID=r.Student_ID " +
                            "JOIN Examination e ON r.Exam_ID=e.Exam_ID " +
                            "JOIN Subject s ON e.Subject_ID=s.Subject_ID " +
                            "WHERE r.Marks_Obtained = (" +
                            "SELECT MAX(r2.Marks_Obtained) " +
                            "FROM Result r2 " +
                            "JOIN Examination e2 ON r2.Exam_ID=e2.Exam_ID " +
                            "WHERE e2.Subject_ID=s.Subject_ID)";

            insert_pst = conn.prepareStatement(query_student);
            insert_pst_Subj = conn.prepareStatement(query_subj);
            insert_pst_exam = conn.prepareStatement(query_exam);
            insert_pst_result = conn.prepareStatement(query_result);

            update_pst_students = conn.prepareStatement(query_update_marks);
            update_pst_student = conn.prepareStatement(query_update_student);
            update_pst_subject = conn.prepareStatement(query_update_subject);
            update_pst_exam = conn.prepareStatement(query_update_exam);

            avg_pst = conn.prepareStatement(query_average);
            highest_pst = conn.prepareStatement(query_highest);

            logg.info("All PreparedStatements created successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Error preparing statements", e);
        }
    }

    public void InsertStudent() {

        System.out.println("Enter Student ID");
        String id = r.nextLine();

        System.out.println("Enter Student Name");
        String name = r.nextLine();

        System.out.println("Enter Student Program");
        String program = r.nextLine();

        System.out.println("Enter Semester");
        int sem = r.nextInt();
        r.nextLine();

        System.out.println("Enter Email");
        String email = r.nextLine();

        try {

            insert_pst.setString(1, id);
            insert_pst.setString(2, name);
            insert_pst.setString(3, program);
            insert_pst.setInt(4, sem);
            insert_pst.setString(5, email);

            insert_pst.executeUpdate();

            logg.info("Student inserted successfully");
            System.out.println("Student inserted successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Student insertion failed", e);
        }
    }

    public void InsertSubject() {

        System.out.println("Enter Subject ID");
        String id = r.nextLine();

        System.out.println("Enter Subject Name");
        String name = r.nextLine();

        System.out.println("Enter Subject Credits");
        int credits = r.nextInt();

        System.out.println("Enter Subject Semester");
        int sem = r.nextInt();
        r.nextLine();

        try {

            insert_pst_Subj.setString(1, id);
            insert_pst_Subj.setString(2, name);
            insert_pst_Subj.setInt(3, sem);
            insert_pst_Subj.setInt(4, credits);

            insert_pst_Subj.executeUpdate();

            logg.info("Subject inserted successfully");
            System.out.println("Subject inserted successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Subject insertion failed", e);
        }
    }

    public void InsertExam() {

        System.out.println("Enter Examination ID");
        String id = r.nextLine();

        System.out.println("Enter Subject ID");
        String subject = r.nextLine();

        System.out.println("Enter Examination Date");
        String exam = r.nextLine();

        System.out.println("Enter Max Marks");
        double marks = r.nextDouble();
        r.nextLine();

        try {

            insert_pst_exam.setString(1, id);
            insert_pst_exam.setString(2, subject);
            insert_pst_exam.setString(3, exam);
            insert_pst_exam.setDouble(4, marks);

            insert_pst_exam.executeUpdate();

            logg.info("Examination inserted successfully");
            System.out.println("Examination inserted successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Examination insertion failed", e);
        }
    }

    public void InsertResult() {

        System.out.println("Enter Examination ID");
        String exam = r.nextLine();

        System.out.println("Enter Student ID");
        String id = r.nextLine();

        System.out.println("Enter Marks Obtained");
        double marks = r.nextDouble();
        r.nextLine();

        System.out.println("Enter Grade");
        String grade = r.nextLine();

        try {

            insert_pst_result.setString(1, exam);
            insert_pst_result.setString(2, id);
            insert_pst_result.setDouble(3, marks);
            insert_pst_result.setString(4, grade);

            insert_pst_result.executeUpdate();

            logg.info("Student marks inserted successfully");
            System.out.println("Marks inserted successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Marks insertion failed", e);
        }
    }

    public void updateResult() {

        System.out.println("Enter Student ID");
        String id = r.nextLine();

        System.out.println("Enter Examination ID");
        String exam = r.nextLine();

        System.out.println("Enter Updated Marks");
        double marks = r.nextDouble();
        r.nextLine();

        System.out.println("Enter Updated Grade");
        String grade = r.nextLine();

        try {

            update_pst_students.setDouble(1, marks);
            update_pst_students.setString(2, grade);
            update_pst_students.setString(3, exam);
            update_pst_students.setString(4, id);

            int rows = update_pst_students.executeUpdate();

            System.out.println(rows + " Result record updated");

            logg.info("Student result updated successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Result update failed", e);
        }
    }

    public void UpdateStudent() {

        System.out.println("Enter Student ID to update");
        String id = r.nextLine();

        System.out.println("Enter New Student Name");
        String name = r.nextLine();

        System.out.println("Enter New Program");
        String program = r.nextLine();

        System.out.println("Enter New Semester");
        int sem = r.nextInt();
        r.nextLine();

        System.out.println("Enter New Email");
        String email = r.nextLine();

        try {

            update_pst_student.setString(1, name);
            update_pst_student.setString(2, program);
            update_pst_student.setInt(3, sem);
            update_pst_student.setString(4, email);
            update_pst_student.setString(5, id);

            int rows = update_pst_student.executeUpdate();

            System.out.println(rows + " Student record updated");

            logg.info("Student updated successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Student update failed", e);
        }
    }

    public void UpdateSubject() {

        System.out.println("Enter Subject ID to update");
        String id = r.nextLine();

        System.out.println("Enter New Subject Name");
        String name = r.nextLine();

        System.out.println("Enter New Semester");
        int sem = r.nextInt();

        System.out.println("Enter New Credits");
        int credits = r.nextInt();
        r.nextLine();

        try {

            update_pst_subject.setString(1, name);
            update_pst_subject.setInt(2, sem);
            update_pst_subject.setInt(3, credits);
            update_pst_subject.setString(4, id);

            int rows = update_pst_subject.executeUpdate();

            System.out.println(rows + " Subject record updated");

            logg.info("Subject updated successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Subject update failed", e);
        }
    }

    public void UpdateExam() {

        System.out.println("Enter Examination ID to update");
        String id = r.nextLine();

        System.out.println("Enter New Subject ID");
        String subjectID = r.nextLine();

        System.out.println("Enter New Examination Date");
        String date = r.nextLine();

        System.out.println("Enter New Maximum Marks");
        double marks = r.nextDouble();
        r.nextLine();

        try {

            update_pst_exam.setString(1, subjectID);
            update_pst_exam.setString(2, date);
            update_pst_exam.setDouble(3, marks);
            update_pst_exam.setString(4, id);

            int rows = update_pst_exam.executeUpdate();

            System.out.println(rows + " Examination record updated");

            logg.info("Examination updated successfully");

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Examination update failed", e);
        }
    }

    public void CalculateAverage() {

        try {

            ResultSet rs = avg_pst.executeQuery();

            System.out.println("\nSUBJECT-WISE AVERAGE MARKS");

            while (rs.next()) {

                String id = rs.getString("Subject_ID");
                String name = rs.getString("Subject_Name");
                double average = rs.getDouble("Average_Marks");

                System.out.println("----------------------------");
                System.out.println("Subject ID: " + id);
                System.out.println("Subject Name: " + name);
                System.out.println("Average Marks: " + average);
            }

            logg.info("Subject-wise average marks calculated successfully");

            rs.close();

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Error calculating average marks", e);
        }
    }

    public void HighestScoringStudents() {

        try {

            ResultSet rs = highest_pst.executeQuery();

            System.out.println("\nHIGHEST SCORING STUDENTS");

            while (rs.next()) {

                String subjectID = rs.getString("Subject_ID");
                String subjectName = rs.getString("Subject_Name");

                String studentID = rs.getString("Student_ID");
                String studentName = rs.getString("Student_Name");

                double marks = rs.getDouble("Marks_Obtained");

                System.out.println("----------------------------");
                System.out.println("Subject ID: " + subjectID);
                System.out.println("Subject Name: " + subjectName);
                System.out.println("Student ID: " + studentID);
                System.out.println("Student Name: " + studentName);
                System.out.println("Highest Marks: " + marks);
            }

            logg.info("Highest scoring students identified successfully");

            rs.close();

        } catch (Exception e) {
            logg.log(Level.SEVERE, "Error finding highest scoring students", e);
        }
    }
}
