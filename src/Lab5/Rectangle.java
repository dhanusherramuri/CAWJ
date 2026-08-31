package Lab5;

public class Rectangle extends Shape{
    private  double width;
    private  double length;

    Rectangle(){
        this.width = 1;
        this.length = 1;
    }

    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    Rectangle (double width, double length, String color, boolean filled){
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    double getWidth(){
        return this.width;
    }

    void setWidth(double width){
        this.width = width;
    }

    void setLength(double length){
        this.length = length;
    }

    double getLength(){
        return this.length;
    }

    public String toString(){
        return "A Rectangle with width = "+this.getWidth()+" and length = "+this.getLength()+" which is a subclass of "+super.toString()+".\n";
    }
}
