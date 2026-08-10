package lab1;
import java.util.*;

public class Assignment1 {
    private static Scanner r;
    public static void main(String [] args){
        r = new Scanner(System.in);
        String s = new String();
        s = r.next();
        int x = s.length();
        System.out.println("Entered String length : "+ x);
        char chars[] = s.toCharArray();
        for(int i = 0 ; i < x ; i++){
            for(int j = i+1 ; j < x ; j++){
                if (chars[i] >= chars [j]){
                    char t = chars [i];
                    chars[i] = chars [j];
                    chars [j] = t;
                }
            }
        }
        String chs = String.copyValueOf(chars);
        System.out.print(chs );
    }
}
