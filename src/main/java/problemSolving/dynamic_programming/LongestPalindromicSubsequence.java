package problemSolving.dynamic_programming;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Stack;

public class LongestPalindromicSubsequence {
    int maxLen;

    /**
     * LCS with reverse string
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        maxLen = 1;
        int iMax = 0, jMax = 0;
        String reverseStr = StringUtils.reverse(s);
        int dp[][] = new int[len + 1][len + 1]; //why len+1 ? -> to initialize first row, column with 0.

        //0th indexes are initialized with 0, so we will start with 1
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (s.charAt(i - 1) == reverseStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    iMax = i;
                    jMax = j;
                }
            }
        }
        print(iMax, jMax, dp, s);
        return maxLen;
    }

    //TODO: fix this logic
    private void print(int imax, int jmax, int[][] dp, String a) {
        StringBuilder builder = new StringBuilder();
        /**
         * Create longest sub string
         */
        Stack<Character> out = new Stack<>();
        while (imax > 0 && jmax > 0) {
            if (dp[imax][jmax] != 0) {
                out.push(a.charAt(imax - 1));
            }
            imax--;
            jmax--;
        }

        Iterator<Character> iter = out.iterator();
        while (iter.hasNext()) {
            builder.append(out.pop());
        }
        System.out.println(builder.toString());
    }


    public static void main(String[] args) {
        LongestPalindromicSubsequence subsequence = new LongestPalindromicSubsequence();
        Assert.assertEquals(4, subsequence.longestPalindromeSubseq("bbbab"));
        Assert.assertEquals(2, subsequence.longestPalindromeSubseq("cbbd"));
    }
}
