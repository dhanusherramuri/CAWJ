package Lab1;
import java.util.*;

public class Reverse {
    private static Scanner r;
    public static void main(String[] args){
        r = new Scanner (System.in);
        String s1= new String();
        StringBuffer s2 = new StringBuffer();
        s1 = r.next();
        int n =  s1.length();
        for(int i = 0 ; i < n ; i++){
             s2.append(s1.charAt(n-i-1));
        }
        System.out.println( "Original String : " + s1 + "\nReversed String : " + s2);
        System.out.println(s1.length()==s2.length());
    }
}
