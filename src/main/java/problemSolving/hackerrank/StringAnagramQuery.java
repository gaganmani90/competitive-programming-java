package problemSolving.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagramQuery {
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> queries) {
        List<Integer> countAnagram = new ArrayList<>();

        for(String query : queries) {
            int count = 0;
            for(String word : dictionary) {
                if(isAnagram(query, word)) {
                    count++;
                }
            }
            countAnagram.add(count);
        }

        return countAnagram;

    }

    /**
     *
     * @param s
     * @param query
     * @return
     */
     static boolean isAnagram(String s, String query) {
        if(s.length() != query.length()) {
            return false;
        }
        int[] sArr = new int[26];
        int[] queryArr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a'] += 1;
            queryArr[query.charAt(i) - 'a'] += 1;
        }

        return Arrays.equals(sArr, queryArr);
    }
}
