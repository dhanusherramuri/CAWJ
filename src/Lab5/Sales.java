package Lab5;

import java.util.Iterator;

public class Sales extends Item{
    private String type;
    private int sales;
    Sales(String title, String type, double price,int sales){
        super(title,price);
        this.type = type;
        this.sales = sales;
        items.add(this);
    }
    void display(){
        Iterator <Item> i = items.iterator();
        System.out.println("|TITLE|\t\t\t|TYPE|\t|PRICE|\t|SALES|\t");
        while(i.hasNext()){
            Item item = i.next();
            System.out.println(item.toString());
        }
    }

    String getTitle(){
        return super.getTitle();
    }

    double getPrice(){
        return super.getPrice();
    }

    String getType(){
        return this.type;
    }

    int getSales(){
        return this.sales;
    }
    public String toString(){
        return "|"+this.getTitle()+"|\t|"+this.getType()+"|\t|"+this.getPrice()+"|\t|"+this.getSales()+"|\n";
    }

}
