package Lab4;

public class Car_main {

    public static void main(String [] args){
        Car c1 = new Car("Brezza","VX","02/10/2017","White",650500.00);
        Car c2 = new Car("Venue","SX","20/09/2018","White",750000.00);
        Car c3 = new Car("Ciaz","VX","15/12/2015","White",600000.00);
        Car c4 = new Car();
        c1.insert();
        c2.insert();
        c3.insert();


//        assert (c1.getName().equals("Brezza"));
//        assert (c1.getModel().equals("VX"));
//        assert (c1.getYop().equals("02/10/2017"));
//        assert (c1.getColour().equals("White"));
//        c2.setName("MERC");
//        c1.setName("VOLKSWAGEN");
//        System.out.println(c3);
//        System.out.println(c2);
//        System.out.println(c1);
        c4.display();
        c4.sell();
        c4.display();
    }
}
