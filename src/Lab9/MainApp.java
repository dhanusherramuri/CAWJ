package Lab9;
import java.io.*;
import java.util.*;

public class MainApp {
    public static Scanner r = new Scanner(System.in);
    public static void main(String [] args){
        boolean flag = true;
        EmployeeDAO ED = new EmployeeDAO();
        ED.prepareDAO();
        while(flag){
            System.out.println( "1. INSERT \n" +
                                "2. DISPLAY\n"+
                                "3. QUIT\n");
            int choice = r.nextInt();
            switch(choice){
                case 1 : {
                    System.out.println("Enter ID : \n ");
                    int id = r.nextInt();
                    System.out.println("Enter Name : \n ");
                    String name = r.next();
                    System.out.println("Enter Salary : \n ");
                    int sal = r.nextInt();
                    ED.insertEMP(id,name,sal);
                    break;
                }
                case 2 : {
                    ED.fetchDAO();
                    break;
                }
                case 3 : {
                    System.out.println("EXITING");
                    flag = false;
                    break;
                }
                default : {
                    System.out.println("ENTER A CORRECT CHOICE");
                    break;
                }
            }
        }

    }
}
