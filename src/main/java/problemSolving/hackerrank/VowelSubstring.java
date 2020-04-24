package problemSolving.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class VowelSubstring {
    public static String findSubstring(String s, int k) {
        if(k > s.length()) {
            return "Not found!";
        }
        int left=0, right=left+k; //window

        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        //initialize for first window
        int vowelCount = vowelCount(s.substring(left, right), vowelSet);

        for(int i = 1; i < s.length(); i++) {
            if(i+k <= s.length()) {
                int tempCount = vowelCount(s.substring(i, i+k), vowelSet);
                if(tempCount > vowelCount) {
                    vowelCount = tempCount;
                    left = i;
                    right = i+k;
                }
            }
        }


        return vowelCount > 0  ?  s.substring(left, right) : "Not found!";
    }

    private static int vowelCount(String s, Set<Character> vowels) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(vowels.contains(c)){
                count++;
            }
        }
        return count;
    }

}
