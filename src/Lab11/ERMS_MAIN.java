
package Lab11;

import java.util.Scanner;

public class ERMS_MAIN {

    public static void main(String[] args) {

        ERMS obj = new ERMS();

        obj.PrepareERMS();

        Scanner r = obj.r;

        boolean flag = true;

        while (flag) {

            System.out.println("\n===== ERMS MENU =====");

            System.out.println("1. INSERT STUDENT");
            System.out.println("2. INSERT SUBJECT");
            System.out.println("3. INSERT EXAMINATION");
            System.out.println("4. UPDATE STUDENT");
            System.out.println("5. UPDATE SUBJECT");
            System.out.println("6. UPDATE EXAMINATION");
            System.out.println("7. INSERT STUDENT MARKS");
            System.out.println("8. UPDATE STUDENT MARKS");
            System.out.println("9. SUBJECT-WISE AVERAGE MARKS");
            System.out.println("10. HIGHEST SCORING STUDENTS");
            System.out.println("11. EXIT");

            System.out.println("Enter your choice:");

            int n = r.nextInt();
            r.nextLine();

            switch (n) {

                case 1:
                    obj.InsertStudent();
                    break;

                case 2:
                    obj.InsertSubject();
                    break;

                case 3:
                    obj.InsertExam();
                    break;

                case 4:
                    obj.UpdateStudent();
                    break;

                case 5:
                    obj.UpdateSubject();
                    break;

                case 6:
                    obj.UpdateExam();
                    break;

                case 7:
                    obj.InsertResult();
                    break;

                case 8:
                    obj.updateResult();
                    break;

                case 9:
                    obj.CalculateAverage();
                    break;

                case 10:
                    obj.HighestScoringStudents();
                    break;

                case 11:
                    flag = false;
                    System.out.println("Exiting ERMS...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        r.close();
    }
}
