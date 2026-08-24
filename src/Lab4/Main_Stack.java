package Lab4;
import java.util.*;

public class Main_Stack {
    public static Scanner r = new Scanner(System.in);
    public static void main(String args[]){
        int ch;
        Stack s = new Stack();
        while(true){
        System.out.println("\n1. Create a stack\n2. Push\n3. Pop\n4. Display\n5. Empty\n6. Exit");
        ch = r.nextInt();
        if(ch == 6){
            System.out.println("Leaving the application");
            break;
        }
        else{
            switch(ch){
                case 1 :{
                    s.create();
                    break;
                }
                case 2 :{
                    s.push();
                    break;
                }
                case 3 :{
                    s.pop();
                    break;
                }
                case 4 :{
                    s.display();
                    break;
                }
                case 5 :{
                    s.empty();
                    break;
                }
                default:{
                    System.out.println("No Such Operation");
                    break;
                }
            }
        }
        }

    }

}
