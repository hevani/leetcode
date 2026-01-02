package javaapi;

public class Anagram {

    private static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() != b.length()) {
            return false;
        }

        // Frequency array
        int[] freq = new int[26];

        // Count characters in a
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }

        // Subtract characters in b
        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
        }

        // All counts must be zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "margana"));   // true
        System.out.println(isAnagram("CAT", "cat"));           // true
        System.out.println(isAnagram("CAT", "taC"));           // true
        System.out.println(isAnagram("anagramm", "marganaa")); // false
    }
}
