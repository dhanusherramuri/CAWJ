package innerclass;

abstract class Base{
    abstract void base1();
}

interface Calc{

     void add();
     void sub();
     void mul();
     void div();
}

abstract class test2{
    abstract void test1();
}
public class AnonymousInnerDemo {

        void check(){
            Base b1 = new Base() {
                @Override
                void base1() {

                }
            };

            Calc cal = new Calc() {
                @Override
                public void add() {

                }

                @Override
                public void sub() {

                }

                @Override
                public void mul() {

                }

                @Override
                public void div() {

                }
            };
            test2 test = new test2() {
                @Override
                void test1() {

                }
            };
        }
    public static void main(String [] args){


        Base base = new Base() {
            @Override
            void base1() {

            }
        };

        Calc calc = new Calc() {
            @Override
            public void add() {

            }

            @Override
            public void sub() {

            }

            @Override
            public void mul() {

            }

            @Override
            public void div() {

            }
        };


    }
}
