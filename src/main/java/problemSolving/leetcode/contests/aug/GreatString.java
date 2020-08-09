package problemSolving.leetcode.contests.aug;

import org.junit.Assert;

/**
 * Given a string s of lower and upper case English letters.
 *
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 *
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 *
 * Notice that an empty string is also good.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 * Example 2:
 *
 * Input: s = "abBAcC"
 * Output: ""
 * Explanation: We have many possible scenarios, and all lead to the same answer. For example:
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * Example 3:
 *
 * Input: s = "s"
 * Output: "s"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only lower and upper case English letters.
 */
public class GreatString {


    public static String makeGood(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        String goodString = "";
        if (s.length() == 1) {
            return s;
        } else {
            goodString = removeUtil(stringBuilder).toString();
        }
        return goodString;
    }

    private static StringBuilder removeUtil(StringBuilder badString) {
        if (badString.length() == 0 || badString.length() == 1 || badString.toString() == "" || isGoodString(badString.toString())) {
            return badString;
        } else {
            for (int i = 0; i < badString.length() - 1; i++) {
                if (isSameChar(badString.charAt(i), badString.charAt(i + 1))) {
                    badString.deleteCharAt(i);
                    badString.deleteCharAt(i);
                }
            }
        }
        return removeUtil(badString);
    }

    private static boolean isSameChar(char c1, char c2) {
        return Math.abs(c2 - c1) == 32;
    }

    private static boolean isGoodString(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (isSameChar(str.charAt(i), str.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Assert.assertEquals(makeGood("abBAcC"), "");
        Assert.assertEquals(makeGood("leEeetcode"), "leetcode");
        Assert.assertEquals(makeGood("s"), "s");
        Assert.assertEquals(makeGood("aAbczZZz"),"bc");
    }
}
