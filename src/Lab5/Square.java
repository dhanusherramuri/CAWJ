package Lab5;

public class Square extends Rectangle{
    Square(){
        super();
    }
    Square(double side){
        super(side,side);
    }
    Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }
    double getSide(){
        return super.getLength();
    }
    void setSide(double side){
        super.setLength(side);
        super.setWidth(side);
    }
    void setWidth(double side){
        super.setWidth(side);
    }
    void setLength(double side){
        super.setLength(side);
    }

    public String toString(){
        return "A Square with side = "+super.getLength()+" which is a subclass of "+super.toString()+".\n";
    }

}
