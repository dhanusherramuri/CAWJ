package Lab5;

public class Shape_Main {
    public static void main(String [] args){
        Shape s = new Shape();
        Shape s1 = new Shape("RED",true);
        assert(s.getColour().equalsIgnoreCase("GREEN"));
        assert(s.isFilled());
        assert(s1.getColour().equalsIgnoreCase("RED"));
        assert(s1.isFilled());
        System.out.println(s1.toString());
        Circle c = new Circle();
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(5, "BLACK", true);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        assert(c.getRadius() == 1);
        assert(c2.isFilled());
        assert (c2.getColour().equalsIgnoreCase("BLACk"));
        Rectangle r = new Rectangle();
        Rectangle r1 = new Rectangle(5,6);
        Rectangle r2 = new Rectangle(6,8,"Red",true);
        assert(r.getColour().equalsIgnoreCase("GREEN"));
        assert(r1.getLength()==6);
        assert (r2.getLength()==8);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        Square sr = new Square();
        Square sr1 = new Square(5);
        Square sr2 = new Square(8,"Red",true);
        assert(sr.getColour().equalsIgnoreCase("GREEN"));
        assert(sr1.getLength()==5);
        assert (sr2.getLength()==8);
        System.out.println(sr1.toString());
        System.out.println(sr2.toString());

    }

}
