package Lab6;

 class Calculator_Main{
     private static void test(){
         Calculator calc = BasicCalculator.getInstance();
        assert (calc.put(101)
                .put(-1)
                .add()
                .read()==100);
        System.out.println("\nADD ASSERTION PASSED");
        calc.clearAll();
        assert(calc.put(10)
                .put(50)
                .mul()
                .read() == 500);
        System.out.println("\nMULTIPLICATION ASSERTION PASSED");
        calc.clearAll();
        assert(calc.put(5)
                .put(1)
                .sub()
                .read() == 4);
        System.out.println("\nSUBTRACTION ASSERTION PASSED");
        calc.clearAll();;
        assert(calc.put(5)
                .put(0)
                .add()
                .neg()
                .read() == -5);
        System.out.println("\nNEGATION ASSERTION PASSED");
        calc.clearAll();
        assert(calc.put(10)
                .put(5)
                .div()
                .read() == 2);
        System.out.println(("\nDIVISION ASSERTION PASSED"));
     }
     public static void main(String []args){
         test();
     }
}
