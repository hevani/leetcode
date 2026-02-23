package test;


class TrieNode {
    TrieNode[] children = new TrieNode[26];
}

public class DistinctSubstrings {

    // Function to count distinct substrings
    public static int countDistinctSubstrings(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        // Insert all suffixes into the Trie
        for (int i = 0; i < s.length(); i++) {
            TrieNode curr = root;

            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';

                // If node doesn't exist, it's a new substring
                System.out.println(idx+ ">>>" + curr.children[idx]);
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                    count++;
                }

                curr = curr.children[idx];
                System.out.println(count);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "ababa";

        int result = countDistinctSubstrings(s);

        System.out.println("Input string: " + s);
        System.out.println("Distinct substrings count = " + result);
        

    }
}
