package Lab2;
import java.io.*;
import java.util.*;
public class Main {
    public static Scanner r= new Scanner(System.in);

    public static void constructArray(int n){
        System.out.println("Enter the size of the array");
        int size= r.nextInt();
        int a[] = new int[size];
        System.out.println("Enter the Array Elements");
        for(int i =0; i< size; i++){
            a[i] = r.nextInt();
        }
        switch(n){
            case 1: {
                duplicate(a, size);
                break;
            }
            case 2 :{
                min_max(a, size);
                break;
            }
            case 3 : {
                pos_neg(a, size);
                break;
            }
            default :{
                System.out.println("Invalid ");
                break;
            }
        }
    }

    //Method to Print the array without duplicate elements
    public static void duplicate(int a[],int size){
        int b[] = new int[size];
        int k=0;
        for(int i = 0;i<size; i++){
            for(int j=i+1;j<size;j++){
                if(a[i]==a[j]){
                    b[k] = a[i];
                    k++;
                    break;
                }
            }
        }
        System.out.print("Duplicate Elements : ");
        for(int i=0; i < k;i++){
            System.out.print(b[i]+" ");
        }
    }

    //Method to find the minimum and maximum in the array

    public static void min_max(int a[],int size){
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
        int choice,t;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(a[i] > a[j]){
                    t= a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        System.out.println("Enter the position to check the element");
        choice = r.nextInt();
//        for(int i = 0 ; i < size; i++){
//            if(a[i]<min){
//                min = a[i];
//            }
//            else if(a[i] > max){
//                max = a[i];
//            }
//        }
        System.out.println("Minimum Element : "+a[choice-1]+"\nMaximum Element : "+a[size-choice]);
    }

    //Positive to right and negative to the left
    public static void pos_neg(int a[],int size){
        int t;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(a[i] > a[j]){
                    t= a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        System.out.print("POS_NEG : ");
        for(int i=0;i<size;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void User_Test(){
        System.out.println("What is your User Id");
        String ans = new String();
        boolean pass=false;
        System.out.print("Enter your Answer : ");
        ans= r.next();
        int c=1;
        while(c<3){
            if(ans.equalsIgnoreCase("User")){
                System.out.println("Correct Answer");
                break;
            }
            else{
                System.out.print("\nYou have "+(3-c)+" attempts left\nEnter your Answer : ");
                c++;
                ans = r.next();
            }
        }
        if(c==3){
            if(ans.equalsIgnoreCase("User")) {
                System.out.println("Correct Answer");
            }
            else{
                System.out.println("\nCorrect answer is User");
            }
            c=0;
        }
    }

    public static void floyds(){
        int val=1,val2=1,range;
        System.out.println("Enter the range of the triangle");
        range = r.nextInt();
        System.out.println("***********Floyds Triangle 1 ***********");
        for(int i=0;i<range;i++){
            for(int j=0;j<=i;j++){
                System.out.print(val+" ");
                val++;
            }
            System.out.println("");
        }
        System.out.println("***********Floyds Triangle 2***********");
        for(int i=0;i<range;i++){
            int f = (i%2==0)?1:0;
            for(int j=0;j<=i;j++){
                    System.out.print(f+" ");
                    f = 1-f;
            }
            System.out.println("");
        }
    }

    public static void mainApp(){
        while(true) {
            System.out.println("\n\n1. Duplicate Values of Array\n2. Find Smallest and Largest elements of an array" +
                    "\n3. move every positive number to the left and negative to the right\n4. Java Program to test user" +
                    "\n5. Print Floyds Triangle\nEnter CTRL^C to Exit\nEnter Your Choice");

            int n;
            n = r.nextInt();
            switch (n) {
                case 1: {
                    constructArray(1);
                    break;
                }
                case 2: {
                    constructArray(2);
                    break;
                }
                case 3: {
                    constructArray(3);
                    break;
                }
                case 4: {
                    User_Test();
                    break;
                }
                case 5: {
                    floyds();
                    break;
                }
                default:{
                    System.out.println("Wrong Input");
                    break;
                }
            }
        }
    }

    public static void main (String args[]){
        String name = new String();
        String password = new String();
        System.out.println("Enter User Id");
        name = r.next();
        System.out.println("Enter Password");
        password = r.next();
        mainApp();
        if((name.equalsIgnoreCase("admin")||name.equalsIgnoreCase("user"))&&(password.equalsIgnoreCase("admin")||password.equalsIgnoreCase("user"))){
            mainApp();
            System.out.println("Success");
        }
        else{
            System.out.println("Invalid User");
        }
    }
}
