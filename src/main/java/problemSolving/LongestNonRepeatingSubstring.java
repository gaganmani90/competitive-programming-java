package problemSolving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestNonRepeatingSubstring {
    public static int longestSubstring(String s) {
        //will store contigous unique characters only
        Map<Character, Integer> map = new HashMap();
        int count = 0;

        //i will only move when a duplicate is found
        //max window of [i to j] is the answer
        for(int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if(map.containsKey(c)) {
                //Max condition is important so that sliding window always
                //starts from max i and not from prev duplicate index if it was less than i.
                i = Math.max(map.get(c)+1, i);
            }
            count = Math.max(count, j-i+1);
            map.put(c, j);
        }

        return count;
    }
}
