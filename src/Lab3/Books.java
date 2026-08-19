package Lab3;

import java.util.*;
import java.io.*;

public class Books {

    public static ArrayList<Books> Details = new ArrayList<>();
    private String author, title, publisher;
    private double price;
    private int stock;


        Books(String title, String author, String publisher, double price, int stock) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.price = price;
            this.stock = stock;

            Details.add(this);  // Add this book to the list
        }
//    Details.add(new Books("Java", "Oak", "Gosling", 500,50));
    Scanner r = new Scanner(System.in);
    void search(){
        System.out.println("Enter the Title of the Book : ");
        String title1 = r.nextLine();
        System.out.println("Enter the Author of the Book : ");
        String auth = r.nextLine();
        boolean found = false;

        for(Books b : Details){
            if((title1.equalsIgnoreCase(b.title))&&(auth.equalsIgnoreCase(b.author))){
                found = true;
                System.out.println("Title : "+b.title+"\nAuthor : "+b.author+"\nPublisher : "+b.publisher+"\nPrice : "+b.price);
                System.out.println("Enter the Required Quantity of Books : ");
                int quant = r.nextInt();
                if(quant <= b.stock){
                    System.out.println("Total Cost for the required copies : "+(quant * b.price)+"\nYes to buy \n No to leave");
                    r.nextLine();
                    String ch = r.nextLine();
                    if(ch.equalsIgnoreCase("Yes")){
                        System.out.println("Purchase Successful!!!");
                        System.out.println("Available Stock : "+(b.stock-quant));
                    }
                    if(ch.equalsIgnoreCase("NO")){
                        System.out.println("Thank You For Visiting");
                    }
                break;
                }
                else{
                    System.out.println("Required Copies not in stock");
                    break;
                }
            }
        }
            if(!found){
                System.out.println("Thanks for Reaching out\n We dont have the required books");
            }
    }
}
