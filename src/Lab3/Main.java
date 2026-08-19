package Lab3;
import java.util.*;
import java.io.*;

 public class Main{
    static Scanner r = new Scanner(System.in);
    public static void main(String args[]){
        while(true){
        System.out.println("1. New User\n2. Existing User\n3. Leave Application");
        int c;
        c = r.nextInt();
        if(c == 3){
            System.out.println("Leaving .....");
            break;
        }
        else{
        Employee e = new Employee(1,"Dhanush","SWE",50000.00);
        switch (c){
            case 1 :{
                System.out.println("Enter the Employee Id :");
                int id = r.nextInt();
                r.nextLine();
                System.out.println("Enter the Name of the Employee : ");
                String name = r.nextLine();
                System.out.println("Enter the Designation of the Employee : ");
                String designation = r.nextLine();
                System.out.println("Enter the Salary of the Employee : ");
                double salary = r.nextDouble();
                Employee emp = new Employee(id,name,designation,salary);
                emp.add_user();
                break;
            }
            case 2:{
                int ch;
                System.out.println("1. Search\n2. Salary Increment\n3. Delete\n4. Display");
                ch = r.nextInt();
                if(ch == 1){
                    e.search_user();
                }
                else if(ch == 2){
                    e.salary_increment();
                }
                else if(ch == 3){
                    e.delete();
                }
                else if(ch == 4){
                    e.display();
                }
                break;
            }
            default:{
                System.out.println("Enter a valid choice");
                break;
            }
        }
        }
        }
    }
}
