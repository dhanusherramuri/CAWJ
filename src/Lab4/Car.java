package Lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class Car {

    static public Scanner r= new Scanner(System.in);
    private String name;
    private String model;
    private String Yop;
    private String colour;
    private double price;

    public static ArrayList<Car> Cars = new ArrayList<>();

    Car(String name, String model, String Yop, String colour,double price){
        this.name = name;
        this.model = model;
        this.Yop = Yop;
        this.colour = colour;
        this.price = price;
    }

    public void insert(){
        Cars.add(this);
        System.out.println("Details of Car "+this.name+" added Successfully");
    }

    public void display(){
        Iterator<Car> e = Cars.iterator();
        while (e.hasNext()) {
            Car car = e.next();
            System.out.println(car);
        }
    }

    public void sell() {
        Iterator<Car> e = Cars.iterator();

        while (e.hasNext()) {
            Car car = e.next();
            System.out.println(car);
        }

        System.out.println("1. Buy\n2. Leave\nENTER YOUR CHOICE :");
        int ch = r.nextInt();
        r.nextLine();

        switch (ch) {
            case 1: {
                System.out.println("Enter The Car Name : ");
                String buy = r.nextLine();

                Iterator<Car> iterator = Cars.iterator();

                while (iterator.hasNext()) {
                    Car car = iterator.next();

                    if (car.getName().equalsIgnoreCase(buy)) {
                        System.out.println("Car " + car.getName() + " sold Successfully");

                        iterator.remove();
                        return;
                    }
                }

                System.out.println("Car not found.");
                break;
            }

            case 2: {
                System.out.println("Thank You For Visiting!!");
                break;
            }

            default: {
                System.out.println("INVALID SELECTION");
                break;
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getModel(){
        return model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYop(){
        return Yop;
    }

    public void setYop(String yop) {
        Yop = yop;
    }

    public String getColour(){
        return colour;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){

        return name+" ,\t"+model+" ,\t"+Yop+" ,\t"+colour+",\tINR "+price+"\n";
    }
}
