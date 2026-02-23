package test;
import java.util.*;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();   // number of test cases
        sc.nextLine();          // consume newline
        
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine().trim();
            if (canFormPalindrome(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }

    // Function to check if a string can be rearranged into a palindrome
    private static boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // For palindrome anagram: at most ne character can have odd frequency
        return oddCount <= 1;
    }
}
