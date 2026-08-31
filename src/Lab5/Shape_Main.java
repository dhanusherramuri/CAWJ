package Lab5;

//public class Shape_Main {
//    public static void main(String [] args){
//        Shape s = new Shape();
//        Shape s1 = new Shape("RED",true);
//        assert(s.getColour().equalsIgnoreCase("GREEN"));
//        assert(s.isFilled());
//        assert(s1.getColour().equalsIgnoreCase("RED"));
//        assert(s1.isFilled());
//        System.out.println(s1.toString());
//        Circle c = new Circle();
//        Circle c1 = new Circle(5);
//        Circle c2 = new Circle(5, "BLACK", true);
//        System.out.println(c1.toString());
//        System.out.println(c2.toString());
//        assert(c.getRadius() == 1);
//        assert(c2.isFilled());
//        assert (c2.getColour().equalsIgnoreCase("BLACk"));
//        Rectangle r = new Rectangle();
//        Rectangle r1 = new Rectangle(5,6);
//        Rectangle r2 = new Rectangle(6,8,"Red",true);
//        assert(r.getColour().equalsIgnoreCase("GREEN"));
//        assert(r1.getLength()==6);
//        assert (r2.getLength()==8);
//        System.out.println(r1.toString());
//        System.out.println(r2.toString());
//        Square sr = new Square();
//        Square sr1 = new Square(5);
//        Square sr2 = new Square(8,"Red",true);
//        assert(sr.getColour().equalsIgnoreCase("GREEN"));
//        assert(sr1.getLength()==5);
//        assert (sr2.getLength()==8);
//        System.out.println(sr1.toString());
//        System.out.println(sr2.toString());
//
//    }
//
//}


public class Shape_Main {

    public static void main(String[] args) {

        // =========================
        // Shape
        // =========================

        Shape s = new Shape();
        Shape s1 = new Shape("RED", true);

        assert(s.getColour().equalsIgnoreCase("GREEN"));
        assert(s.isFilled());

        assert(s1.getColour().equalsIgnoreCase("RED"));
        assert(s1.isFilled());

        // Test setters
        s.setColour("BLUE");
        s.setFilled(false);

        assert(s.getColour().equalsIgnoreCase("BLUE"));
        assert(!s.isFilled());

        System.out.println(s1.toString());


        // =========================
        // Circle
        // =========================

        Circle c = new Circle();
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(5, "BLACK", true);

        assert(c.getRadius() == 1);
        assert(c1.getRadius() == 5);
        assert(c2.getRadius() == 5);

        assert(c2.isFilled());
        assert(c2.getColour().equalsIgnoreCase("BLACK"));

        // Test setter
        c.setRadius(10);

        assert(c.getRadius() == 10);

        // Test area
        assert(c1.getArea() == 3.14 * 25);

        // Test perimeter
        assert(c1.Perimeter() == 2 * 3.14 * 5);

        System.out.println(c1.toString());
        System.out.println(c2.toString());


        // =========================
        // Rectangle
        // =========================

        Rectangle r = new Rectangle();
        Rectangle r1 = new Rectangle(5, 6);
        Rectangle r2 = new Rectangle(6, 8, "Red", true);

        assert(r.getColour().equalsIgnoreCase("GREEN"));
        assert(r.getWidth() == 1);
        assert(r.getLength() == 1);

        assert(r1.getWidth() == 5);
        assert(r1.getLength() == 6);

        assert(r2.getWidth() == 6);
        assert(r2.getLength() == 8);
        assert(r2.getColour().equalsIgnoreCase("RED"));
        assert(r2.isFilled());

        // Test setters
        r.setWidth(10);
        r.setLength(20);

        assert(r.getWidth() == 10);
        assert(r.getLength() == 20);

        // Test area
//        assert(r1.() == 30);

        // Test perimeter
//        assert(r1.Perimeter() == 22);

        System.out.println(r1.toString());
        System.out.println(r2.toString());


        // =========================
        // Square
        // =========================

        Square sr = new Square();
        Square sr1 = new Square(5);
        Square sr2 = new Square(8, "Red", true);

        assert(sr.getColour().equalsIgnoreCase("GREEN"));
        assert(sr.getWidth() == 1);
        assert(sr.getLength() == 1);

        assert(sr1.getWidth() == 5);
        assert(sr1.getLength() == 5);

        assert(sr2.getWidth() == 8);
        assert(sr2.getLength() == 8);

        assert(sr2.getColour().equalsIgnoreCase("RED"));
        assert(sr2.isFilled());

        // Test setWidth()
        sr1.setWidth(10);

        assert(sr1.getWidth() == 10);
//        assert(sr1.getLength() == 10);

        // Test setLength()
        sr2.setLength(12);

//        assert(sr2.getWidth() == 12);
        assert(sr2.getLength() == 12);

        // Test inherited area
//        assert(sr1.getArea() == 100);

        // Test inherited perimeter
//        assert(sr1.getPerimeter() == 40);

        System.out.println(sr1.toString());
        System.out.println(sr2.toString());


        System.out.println("All assertions passed!");
    }
}
