package Lab4;

public class Book_Main {
    public static void main(String[] args){
        Author a1 = new Author("EDRK","edrk@gmail.com",'M');
        Author a2 = new Author("Dhanush","Dhanush@gmail.com",'M');
        Author a3 = new Author("RajKumar","Raj@gmail.com",'M');

        Book b1 = new Book("Java Intro",a2,1875,20);

        assert(b1.getPrice()==1875.00);
        assert(b1.getQty() == 20);
        b1.setQty(25);
        assert(b1.getQty() == 25);
        b1.setPrice(2000);
        assert(b1.getPrice() == 2000);
//        System.out.println("assertions passed");
    }
}
