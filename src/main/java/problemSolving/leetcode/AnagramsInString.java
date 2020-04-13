package problemSolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class AnagramsInString {
    private Map<Character, Integer> anagramMap = new HashMap<>();
    private int windowSize = 0;
    private String fullString;

    /**
     * Main method
     * @param str
     * @param anagram
     *
     * Leetcode runtime: TODO: optimize
     * Runtime: 1796 ms, faster than 5.81% of Java online submissions for Find All Anagrams in a String.
     * Memory Usage: 41.3 MB, less than 6.00% of Java online submissions for Find All Anagrams in a String.
     * @return
     */
    public  List<Integer> findAnagrams(String str, String anagram) {
        List<Integer> indexes = new ArrayList<>();
        windowSize = anagram.length();
        this.fullString = str;
        this.anagramMap = getCharacterMap(anagram); //prepare hashmap

        boolean isAnagram = false;
        int index = -1;
        for(int i = 0; i < str.length();i++) {
            //If previous word was anagram
            //then do not run anagram method, just compare with last character
            if(isAnagram) {
                if((i + windowSize) < str.length()
                        && str.charAt(i-1) == (str.charAt(i + windowSize - 1))) {
                    indexes.add(i);
                    continue;
                }
            }
            index = getAnagramIndex(i);
            if(index != -1) {
                indexes.add(index);
                isAnagram = true;
            } else { isAnagram = false; }
        }
        return indexes;
    }

    /**
     * Utility method to convert a given word to character map
     * @param anagram
     * @return abc will convert to : ['c',1] [b,1][a,1]
     */
    private Map<Character, Integer> getCharacterMap(String anagram) {
        Map<Character, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < anagram.length(); i++) {
            wordMap.merge(anagram.charAt(i), 1, Integer::sum);
        }
        return wordMap;
    }

    /**
     * Returns starting index of window word if its anagram else return -1
     * @param startIndex
     * @return
     */
    private int getAnagramIndex(int startIndex) {
        if(startIndex + windowSize > fullString.length()){
            return -1;
        }
        String compareAnagramWord = fullString.substring(startIndex, startIndex + windowSize);
        return isAnagram(compareAnagramWord) ? startIndex : -1;
    }

    /**
     * compare both the hashmaps
     * @param word
     * @return
     */
    private boolean isAnagram(String word) {
        Map<Character, Integer> wordMap = getCharacterMap(word);
        return wordMap.equals(anagramMap);
    }
}
