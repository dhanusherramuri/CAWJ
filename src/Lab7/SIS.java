package Lab7;
import java.io.*;
import java.util.*;
public class SIS {
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    private static Scanner r = new Scanner(System.in);

    public static void initialize(){
        try{
            br = new BufferedReader(new FileReader("login.txt"));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static boolean authenticate(){
        System.out.print("ENTER THE USERNAME : ");
        String uname = r.next();
        System.out.print("ENTER THE PASSWORD : ");
        String pwd = r.next();

        try{
            String creds = br.readLine();
            while(creds!=null){
                String prof[] = creds.split(" ");
                if(prof[0].equals(uname) && prof[1].equals(pwd)){
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public static void insertUser(){
        System.out.println("ENTER THE ROLL NO : ");
        String rno = r.next();
        System.out.println("ENTER THE NAME TO INSERT : ");
        String name = r.next();
        System.out.println("ENTER THE BRANCH : ");
        String branch = r.next();

        try{
            bw = new BufferedWriter(new FileWriter("student_details.txt",true));
            bw.write(rno+" ");
            bw.write(name+" ");
            bw.write(branch+" ");
            bw.newLine();
            bw.flush();
//            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
//        bw.close();
    }

    public static void deleteUser(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("student_details.txt"));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("student_details.txt"));
            String det = br.readAllAsString();
            String details[] = new String[0];
            details = det.split(" ");

            for(int i =1;i< details.length;i=i+3){
                System.out.println(details[i]);
            }
//            System.out.println("ENTER THE USER TO BE DELETED");
//            String del = r.next();
//            while(det!=null){
//                if(details[0].equals(del)){
//                    System.out.println("DATA WILL BE DELETED");
//                }
//            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void updateUser(){

    }
    public static void display(){
        try{
            br = new BufferedReader(new FileReader("student_details.txt"));
            String det = br.readAllAsString();
            System.out.println(det);

//            br.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String [] args){
        initialize();
//        if(authenticate()){
//            System.out.println("LOGIN SUCCESSFUL");
            while(true){
                System.out.println("1. INSERT USER\n" +
                        "2. DELETE USER\n" +
                        "3. UPDATE USER\n" +
                        "4. DISPLAY\n");
                int n = r.nextInt();
                switch(n) {
                    case 1 :
                        insertUser();
                        break;
                    case 2 :
                        deleteUser();
                        break;
                    case 3 :
                        updateUser();
                        break;
                    case 4 :
                        display();
                        break;
                    case 5 :
//                        return false;
                        break;
                    default :
                        System.out.println("RE CHECK YOUR CHOICE");
                        break;
                }
            }
//        }
//        else{
//            System.out.println("INVALID CREDS");
//        }
    }
}
