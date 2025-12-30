package test;

import java.util.Scanner;

public class SingleTon {

    public String str;
    private static SingleTon singleTon;
    
    private SingleTon() {
        
    }
    private static synchronized SingleTon getSingleInstance() {
         if(singleTon == null) {
            singleTon = new SingleTon();
         }
         
         return singleTon;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        
    	SingleTon s = SingleTon.getSingleInstance();
        Scanner scanner = new Scanner(System.in);
        s.str = scanner.next() + " " + scanner.next();
        scanner.close();
        
      
      System.out.println("Hello I am a singleton! Let me say " + s.str + " to you");
    }
}
