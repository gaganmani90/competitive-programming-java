package dataStructure.trie;

import lombok.Data;
import org.junit.Assert;

import java.util.HashMap;

public class TrieUtility {
    private TrieNode root;

    public TrieUtility() {
        this.root = new TrieNode();
    }

    /**
     * 1. INSERT
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            /**
             * If the current node has already an existing reference to the current letter
             * (through one of the elements in the “children” field),
             * then set current node to that referenced node. Otherwise, create a new node,
             * set the letter equal to the current letter, and also initialize current node to this new node
             */
            if (current.getChildren() != null) {
                current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
            }
        }
        current.setEndOfWord(true);
        current.setContent(word);
    }

    /**
     * 2. SEARCH
     *
     * @param word
     * @return
     */
    public boolean find(String word) {
        TrieNode current = prefix(word);
        return current !=null && current.isEndOfWord();
    }

    /**
     * 3. FIND PREFIX
     *
     * @param prefix
     * @return
     */
    public boolean findPrefix(String prefix) {
        TrieNode current = prefix(prefix);
        return current != null;
    }

    private TrieNode prefix(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return null;
            }
            current = node; //keep moving current node into word's direction
        }
        return current;
    }

    /**
     * 4. FIND BY PATTERN.
     * It handles "." wild card
     *
     * @return
     */
    public boolean findByPattern(String word) {
        return findByPatternUtil(word, root);
    }

    private boolean findByPatternUtil(String word, TrieNode trieNode) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //check all possibilities with wild card in place
            if (!trieNode.getChildren().containsKey(c)) {
                if (c == '.') { //wild card baby, do the hard work now
                    //traverse all child nodes
                    for(TrieNode currNode : trieNode.getChildren().values()) {
                        if(findByPatternUtil(word.substring(i+1), currNode)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                trieNode = trieNode.getChildren().get(c);
            }
        }
        return trieNode.isEndOfWord();
    }

    public static void main(String[] args) {
        TrieUtility trie = new TrieUtility();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        Assert.assertTrue(trie.find("is"));
        Assert.assertTrue(trie.find("Programming"));
        Assert.assertTrue(trie.findPrefix("Programm"));
        Assert.assertFalse(trie.find("Programm"));
        Assert.assertTrue(trie.findByPattern("Programmin."));
        Assert.assertTrue(trie.findByPattern("Pro.ram.in."));
    }


}

@Data
class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private String content;
    private boolean isEndOfWord;
}
