package Lab5;

public class Shape {
    private String colour;
    private boolean filled;

    Shape(){
        this.colour = "Green";
        this.filled = true;
    }

    Shape(String colour, boolean filled){
        this.colour  = colour;
        this.filled  = filled;
    }

    String getColour(){
        return colour;
    }

    void setColour(String colour){
        this.colour = colour;
    }

    boolean isFilled(){
        return filled;
    }

    void setFilled(boolean filled){
        this.filled = filled;
    }

    public String toString(){
        return "A Shape with Colour of "+this.colour+" and "+this.filled+".\n" ;
    }
}
