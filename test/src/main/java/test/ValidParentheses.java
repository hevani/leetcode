package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	
	public static void main(String args[]) {
		
		
		String s1 = "()";		
		System.out.println(s1 + ": "+ isValid(s1));
		
		String s2 = "()[]{}";		
		System.out.println(s2 + ": "+ isValid(s2));
		
		
		String s3 = "(]";		
		System.out.println(s3 + ": "+ isValid(s3));
		
		String s4 = "([])";		
		System.out.println(s4 + ": "+ isValid(s4));
		
		String s5 = "([)]";
		System.out.println(s5 + ": "+ isValid(s5));
		
	}

	public static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for(char ch:s.toCharArray()) {
			switch(ch) {
				case '{' : stack.push('}'); break;
				case '(' : stack.push(')'); break;
				case '[' : stack.push(']'); break;
				
				default:
					if(stack.isEmpty() || !stack.pop().equals(ch)) {
						return false;
					}
			}
		}
		
		return stack.isEmpty();
    }
}
