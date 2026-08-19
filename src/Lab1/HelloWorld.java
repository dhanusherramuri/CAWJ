package Lab1;
import java.util.*;

public class HelloWorld {
       private static Scanner r;
    public static void main(String[] args){
//        System.out.println("Hello World " + args[0]+args[1]);
//        System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
        r = new Scanner(System.in);
        int x = r.nextInt();
        int y = r.nextInt();

        System.out.println("Sum : "+ (x+y));
    }
}
