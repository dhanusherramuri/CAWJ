package Lab7;

import java.io.*;
import java.util.*;

public class SIS {

    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    private static Scanner r = new Scanner(System.in);

    public static void initialize() {
        try {
            br = new BufferedReader(new FileReader("login.txt"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean authenticate() {

        System.out.print("ENTER THE USERNAME : ");
        String uname = r.next();

        System.out.print("ENTER THE PASSWORD : ");
        String pwd = r.next();

        try {
            br = new BufferedReader(new FileReader("login.txt"));

            String creds;

            while ((creds = br.readLine()) != null) {

                String[] prof = creds.split(" ");

                if (prof[0].equals(uname) && prof[1].equals(pwd)) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public static void insertUser() {

        System.out.print("ENTER THE ROLL NO : ");
        String rno = r.next();

        System.out.print("ENTER THE NAME : ");
        String name = r.next();

        System.out.print("ENTER THE BRANCH : ");
        String branch = r.next();

        try {

            bw = new BufferedWriter(new FileWriter("student_details.txt", true));

            bw.write(rno + " " + name + " " + branch);
            bw.newLine();
            bw.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteUser() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("student_details.txt"));

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            String det = sb.toString();

            String[] details = det.split("\\s+");

            System.out.println("CURRENT USERS:");

            for (int i = 1; i < details.length; i += 3) {
                System.out.println(details[i]);
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateUser() {

        System.out.println("UPDATE FUNCTION NOT IMPLEMENTED");

    }

    public static void display() {

        try {

            br = new BufferedReader(new FileReader("student_details.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        initialize();

        // Uncomment if login is required
        /*
        if (!authenticate()) {
            System.out.println("INVALID CREDENTIALS");
            return;
        }

        System.out.println("LOGIN SUCCESSFUL");
        */

        while (true) {

            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. INSERT USER");
            System.out.println("2. DELETE USER");
            System.out.println("3. UPDATE USER");
            System.out.println("4. DISPLAY");
            System.out.println("5. EXIT");

            int n = r.nextInt();

            switch (n) {

                case 1:
                    insertUser();
                    break;

                case 2:
                    deleteUser();
                    break;

                case 3:
                    updateUser();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("THANK YOU");
                    System.exit(0);

                default:
                    System.out.println("RECHECK YOUR CHOICE");
            }
        }
    }
}