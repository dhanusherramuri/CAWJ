package Lab5;

public class Sales_Main {
    public static void main (String [] args){
        Sales s1 = new Sales("Wrench","Hardware",299.0,560);
        Sales s2 = new Sales("CUTTER","Hardware",199.0,500);
        Sales s3 = new Sales("DRILLER","Hardware",699.0,250);
        s1.display();
    }
}
