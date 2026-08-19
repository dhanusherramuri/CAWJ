package Lab3;

import java.util.ArrayList;
import java.util.*;

public class Employee {
   private int empID;
   private String empName, empDesignation;
   private double empSalary;
   public static Scanner r = new Scanner(System.in);

   public static ArrayList<Employee> Details = new ArrayList<>();

   Employee(int id,String name, String designation, double Salary){
      this.empID = id;
      this.empName = name;
      this.empDesignation = designation;
      this.empSalary = Salary;
   }
    void add_user(){
       Details.add(this);
       System.out.println("Details of User "+this.empName+" added Successfully");
    }

    void search_user(){
       System.out.println("Enter the EmpId to search ");
       int eid = r.nextInt();
       boolean f = false;

       for(Employee e : Details){
           if(e.empID == eid){
               System.out.println("Found :"+e.empName+" having Id "+e.empID);
               f = true;
               break;
           }
       }
       if(!f){
           System.out.println("User Id "+eid+" doesnt exist");
       }
    }

    void salary_increment(){
       System.out.println("Enter the empid to increase the salary");
       int eid = r.nextInt();
       boolean found = false;
       for(Employee e : Details){
           if(e.empID == eid){
               e.empSalary = e.empSalary+(e.empSalary * 0.1);
               System.out.println("Updated Salary of "+e.empName+" is :"+e.empSalary);
               found = true;
               break;
           }
       }
       if(!found) {
           System.out.println("User Not Found");
       }
    }

    void display(){
       for(Employee e : Details){
           System.out.println("ID : "+e.empID+"\nName : "+e.empName+"\nDesignation : "+e.empDesignation+"\nSalary : "+e.empSalary);
           System.out.println("---------------");
       }
    }
}
