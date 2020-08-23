package dataStructure.trie;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the StreamChecker class as follows:
 * <p>
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 * <p>
 * <p>
 * Example:
 * <p>
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 */
public class StreamChecker {
    LocalTrieNode root = new LocalTrieNode();
    String wordToSearch = "";

    public StreamChecker(String[] words) {
        //build Trie
        for (String word : words) {
            insertInReverse(word);
        }
    }

    public boolean query(char letter) {
        wordToSearch += letter + "";
        return find(wordToSearch);
    }

    public void insertInReverse(String word) {
        LocalTrieNode current = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            current = current.children.computeIfAbsent(word.charAt(i), l -> new LocalTrieNode());
        }
        current.isWord = true;
    }

    public boolean find(String word) {
        LocalTrieNode current = root;
        //search in reverse
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
            if (current.isWord) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"ab", "ba", "aaab", "abab", "baa"});
        Assert.assertFalse(streamChecker.query('a'));
        Assert.assertFalse(streamChecker.query('a'));
        Assert.assertFalse(streamChecker.query('a'));
        Assert.assertFalse(streamChecker.query('a'));
        Assert.assertFalse(streamChecker.query('a'));
        Assert.assertTrue(streamChecker.query('b'));


        streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        Assert.assertFalse(streamChecker.query('a'));
        Assert.assertFalse(streamChecker.query('b'));
        Assert.assertFalse(streamChecker.query('c'));
        Assert.assertTrue(streamChecker.query('d'));
        Assert.assertFalse(streamChecker.query('e'));
        Assert.assertTrue(streamChecker.query('f'));
    }

    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */
}

class LocalTrieNode {
    Map<Character, LocalTrieNode> children = new HashMap<>();
    boolean isWord;
    String content;
}
