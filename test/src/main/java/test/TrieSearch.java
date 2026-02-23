package test;

class TrieNodeForSearch {
	TrieNodeForSearch[] children = new TrieNodeForSearch[26];
    boolean isEndOfWord;
}

public class TrieSearch {

    private TrieNodeForSearch root;

    public TrieSearch() {
        root = new TrieNodeForSearch();
    }

    // Insert a word into the Trie
    public void insert(String word) {
    	TrieNodeForSearch curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNodeForSearch();
            }

            curr = curr.children[idx];
        }

        curr.isEndOfWord = true;
    }

    // Search for a full word
    public boolean search(String word) {
    	TrieNodeForSearch curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.isEndOfWord;
    }

    // Optional: Check if any word starts with a prefix
    public boolean startsWith(String prefix) {
    	TrieNodeForSearch curr = root;

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    // Test the Trie
    public static void main(String[] args) {
        TrieSearch trie = new TrieSearch();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");

        // Test searches
        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Search 'appl': " + trie.search("appl"));
        System.out.println("Search 'bat': " + trie.search("bat"));
        System.out.println("Search 'ball': " + trie.search("ball"));
        System.out.println("Search 'cat': " + trie.search("cat"));

        // Test prefix
        System.out.println("StartsWith 'ap': " + trie.startsWith("ap"));
        System.out.println("StartsWith 'ba': " + trie.startsWith("ba"));
        System.out.println("StartsWith 'ca': " + trie.startsWith("ca"));
    }
}
