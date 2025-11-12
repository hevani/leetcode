package test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String args[]) {
		int n = 3;
		int n1 = 5;
		int n3 = 15;
		
		System.out.println(n + "-->" + FizzBuzz.fizzBuzz(n));
		System.out.println(n1 + "-->" + FizzBuzz.fizzBuzz(n1));
		System.out.println(n3 + "-->" + FizzBuzz.fizzBuzz(n3));
		
	}
	
	public static List<String> fizzBuzz(int number) {
		List<String> answer = new ArrayList<>();
		for(int i=1; i<=number; i++) {
			if(i% 3 == 0 && i % 5 == 0) answer.add("FizzBuzz");
			else if(i% 3 == 0) answer.add("Fizz");
			else if(i % 5 == 0) answer.add("Buzz");
			else answer.add(i + "");		
		}
		
		return answer;
		
		
	}
}
