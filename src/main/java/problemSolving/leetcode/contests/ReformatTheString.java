package problemSolving.leetcode.contests;

import java.util.ArrayList;
import java.util.List;

/**
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 *
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit.
 * That is, no two adjacent characters have the same type.
 *
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 *
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 *
 * Example 3:
 *
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 *
 * Example 4:
 *
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 *
 * Example 5:
 *
 * Input: s = "ab123"
 * Output: "1a2b3"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 500
 *     s consists of only lowercase English letters and/or digits.
 */
public class ReformatTheString {
    public static String reformat(String s) {
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        boolean isNextLetter = false;
        char[] arr = new char[s.length()];

        createDigitsAndLettersList(digits, letters, s);

        int digitIndex = 0;
        int letterIndex = 0;
        int diff = Math.abs(digits.size() - letters.size());
        //edge case
        if(diff > 1) {
            return "";
        }

        //initialize
        if(digits.size() > letters.size()) {
            arr[0] = digits.get(0);
            isNextLetter = true;
            digitIndex++;
        } else {
            arr[0] = letters.get(0);
            letterIndex++;
        }

        for(int i = 1; i < arr.length; i++) {
            if(isNextLetter) {
                arr[i] = letters.get(letterIndex++);
                isNextLetter = false;
            } else {
                arr[i] = digits.get(digitIndex++);
                isNextLetter = true;
            }
        }


        return String.copyValueOf(arr);
    }

    private static void createDigitsAndLettersList(List<Character> digits, List<Character> letters, String s) {
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                digits.add(c);
            } else if(Character.isLetter(c)) {
                letters.add(c);
            }
        }
    }

}
