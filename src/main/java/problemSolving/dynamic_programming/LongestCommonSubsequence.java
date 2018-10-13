package problemSolving.dynamic_programming;

/**
 * Longest Common Substring count in an Array of Strings
 * <pre>
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * <pre/>
 * @author gagamani
 * @date 9/12/18
 */
public class LongestCommonSubsequence {

    static int lengthOflongestComSubsequence(String a, String b) {

        int[][] Length = new int[a.length() + 1][b.length() + 1];
        int len = 0;

        for (int i = 1; i < Length.length; i++) {
            for (int j = 1; j < Length[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    Length[i][j] = Length[i - 1][j - 1] + 1;

                } else { //if characters are not same then longest comm substring will NOT be zero like common substring
                    Length[i][j] = Math.max(Length[i - 1][j], Length[i][j - 1]);
                }

                len = Math.max(Length[i][j], len);
            }
        }


        return len;

    }


}
