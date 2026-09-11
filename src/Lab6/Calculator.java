package Lab6;

 interface Calculator {
     Calculator put(int n);
     int read();
     Calculator neg();
     Calculator add();
     Calculator sub();
     Calculator div();
     Calculator mul();
     Calculator clear();
     Calculator clearAll();
 }
