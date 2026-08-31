package Lab5;

import java.util.ArrayList;

public class Item {
    public static ArrayList <Item> items= new ArrayList<>();
    private String title;
    private double price;
    Item(String title, double price){
        this.title = title;
        this.price = price;
//        items.add(this);
    }
    String getTitle(){
        return this.title;
    }

    double getPrice(){
        return this.price;
    }
}
