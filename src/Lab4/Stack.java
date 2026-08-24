package Lab4;
import java.util.*;


public class Stack {
//    static int[] arr;
        static Scanner r =  new Scanner(System.in);
        static int top = -1;
        static int n;
        static int [] arr;

    void create(){
        System.out.println("Enter the size of the stack :");
        n = r.nextInt();
        arr = new int[n];
    }

    void push(){
        if(top == n-1){
            System.out.println("Stack is Full");
        }
        else{
            System.out.println("Enter the Data to be pushed");
            int data = r.nextInt();
            arr[++top] = data;
            System.out.println(top);
        }
    }

    void pop(){
        if(top == -1){
            System.out.println("The stack is empty");
        }
        else{
            int data = arr[top];
            top--;
            System.out.println("Deleted Element is  : "+data);
        }
    }

    void display(){
        if(top>-1){
            for(int i = top; i >= 0;i--){
                System.out.print(arr[i]+"\t");
            }
            }
        else{
            System.out.println("EMPTY STACK");
        }
    }

    void empty(){
        if(top == -1){
            System.out.println("STACK IS EMPTY\n");
        }
        else{
            System.out.println("Stack is not Empty\n");
        }
    }
}
