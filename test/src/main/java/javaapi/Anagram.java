package javaapi;

import java.util.Scanner;

public class Anagram {

	private static String isAnagram(String a, String b) {
        String isAnagram = "Not Anagrams";
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() != b.length()) {
            return isAnagram;
        }
        
        int[] freq = new int[26];

        // Count characters in a
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }

        // Subtract characters in b
        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
        }
        
        for (int count : freq) {
            if (count != 0) {
                return isAnagram;
            }
        }

        return "Anagrams";
    }

    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
         
         String a = sc.nextLine();
         String b = sc.nextLine();
         System.out.println(isAnagram(a,b));
    }
}
