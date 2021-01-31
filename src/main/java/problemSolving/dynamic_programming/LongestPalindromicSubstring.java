package problemSolving.dynamic_programming;

import org.junit.Assert;
import utility.PrintUtility;

import java.sql.Struct;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 * <p>
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 * <p>
 * Input: s = "ac"
 * Output: "a"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindromicSubstring {
    int startIndex;
    int maxLen;
    boolean[][] dp;
    String s;
    /**
     * For a string to be a palindrome, first = last; first+1=last-1 and so on.
     * Palindrome(i,j) = ["char(i) == char(j)" && Palindrome(i+1, j-1)].
     * If we have calculated Palindrome(i+1,j-1) then
     * it can be reused to calculate Palindrome(i,j).
     * <p>
     * We can use DP array to store pre-calculated values which we already know, for example - single char is always
     * a palindrome and 2 characters are always palindrome if both are same. We initiate the dp array with this information
     * and keep reusing it to arrive at longest palindrome.
     * <p>
     * ===DP array ===
     * Treat dp[i,j] as s.subString(i,j)
     * dp[i,j] = true ; means s.subString(i,j) is a palindromic string.
     * dp[i,j] = ["dp[i] == dp[j]" && "dp[i+1, j-1] == true"]
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        dp = new boolean[s.length()][s.length()];
        startIndex = 0;
        maxLen = 1; //all characters are palindrome
        initializeForOneCharacter();
        initializeForTwoCharacter(s);
        //System.out.println(PrintUtility.print2dArray(dp));

        if(s.length() > 2) {
            checkPalindrome(s);
        }

        return s.substring(startIndex, startIndex+maxLen);
    }

    private void checkPalindrome(String s) {
        // Check for lengths greater than 2.
        // k is length of substring
        for(int currLen = 3; currLen <= s.length(); currLen++) { //note that it is length, not index
            // Fix the starting index
            for (int startIndex = 0; startIndex < s.length() - currLen + 1; startIndex++) {
                // Get the ending index of substring from
                // starting index  and length
                int endIndex = startIndex + currLen - 1;
                if(isPalindrome(s, startIndex, endIndex)) {
                    dp[startIndex][endIndex] = true;
                    if(currLen > maxLen) {
                        maxLen = currLen;
                        this.startIndex = startIndex;
                    }
                }
            }
        }
    }

    private void initializeForOneCharacter() {
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if(dp[start+1][end-1] == true && s.charAt(start) == s.charAt(end)) {
            return true;
        }
        return false;
    }

    /**
     * if two adjacent chars are same, its palindrome
     *
     */
    private void initializeForTwoCharacter(String s) {
        for (int i = 0; i < dp.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                startIndex = i;
            }
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        Assert.assertEquals("bab",longestPalindromicSubstring.longestPalindrome("babad"));
        Assert.assertEquals("bb",longestPalindromicSubstring.longestPalindrome("cbbd"));
        Assert.assertEquals("a",longestPalindromicSubstring.longestPalindrome("a"));
        Assert.assertEquals("a",longestPalindromicSubstring.longestPalindrome("ac"));
    }
}

class LongestPalindromicSubstring_BruteForce {
    public String longestPalindrome(String s) {
        return null;
    }
}
