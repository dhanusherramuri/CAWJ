package Lab11;

import java.util.Scanner;

public class ERMS_MAIN {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        ERMS obj = new ERMS();
        obj.PrepareERMS();
        boolean flag = true;
        int n;
        while(flag){
            System.out.println("1. INSERT INTO STUDENT DETAILS\n");
            System.out.println("2. INSERT INTO SUBJECT\n");
            System.out.println("3. INSERT INTO EXAMINATION\n");
            System.out.println("4. UPDATE RESULTS\n");
            System.out.println("5. EXIT \n");
            n= r.nextInt();
            switch(n){
                case 1:
                    obj.InsertStudent();
                    break;
                case 2:
                    obj.InsertSubject();
                    break;
                case 3:
                    obj.InsertExam();
                    break;
                case 4:
                    obj.updateResult();
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}
