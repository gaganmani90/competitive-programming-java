package problemSolving;

import java.util.HashSet;

public class LongestNonRepeatingSubstring {
    public static int longestSubstring(String s) {
        if(s == null || s.length() == 0 || s.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int prevDuplicateIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                //remove all previous hashmap elements that occurred before this duplicate
                //example: abcgzg => this will remove all entries before g if it is traversing second g
                while(prevDuplicateIndex < i) {
                    if(s.charAt(prevDuplicateIndex) == c) {
                        prevDuplicateIndex++;
                        break;
                    }
                    set.remove(s.charAt(prevDuplicateIndex));
                    prevDuplicateIndex++;
                }
            } else {
                set.add(c);
                maxLength = Math.max(maxLength,set.size());
            }
        }
        return maxLength;
    }
}
