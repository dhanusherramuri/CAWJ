package Lab5;

public class Circle extends Shape{
    private double radius;
    final double PI = 3.14;
//    private String colour;
//    private boolean filled;
    Circle(){
        this.radius = 1.0;
    }

    Circle(double radius){

        this.radius = radius;
    }

    Circle(double radius, String colour, boolean filled){
        super(colour,filled);
        this.radius = radius;
    }

    String getColour(){
       return super.getColour();
    }

    double getRadius(){
        return radius;
    }

    void setRadius(double radius){
        this.radius = radius;
    }

    double getArea(){
       return PI * radius * radius;
    }

    double Perimeter(){
        return 2 * PI * radius;
    }

    public String toString(){
        return "A Circle with radius "+this.radius+" ,which is a subclass of "+super.toString()+".";
    }

}
