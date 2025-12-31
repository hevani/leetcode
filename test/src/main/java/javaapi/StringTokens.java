package javaapi;

import java.util.Scanner;

public class StringTokens {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] tokens = s.split("[^A-Za-z]+");
		System.out.println(tokens.length);
		for (String token : tokens) {
			System.out.println(token);
		}
	}
}