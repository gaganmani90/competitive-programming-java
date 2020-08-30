package dataStructure.string;

import org.junit.Assert;

import java.util.Arrays;

public class PatternMatchingKMP {

    /**
     *
     * @param text
     * @param pattern
     * @return
     */
    public static int matchingIndex(String text, String pattern) {
        int pIndex = 0, tIndex = 0;
        int[] lps = computeLongestPrefixSuffix(pattern);

        while (tIndex < text.length() && pIndex < pattern.length()) {
            if (pattern.charAt(pIndex) == text.charAt(tIndex)) {
                pIndex++;
                tIndex++;
            } else {
                if (pIndex != 0) {
                    pIndex = lps[pIndex - 1];
                } else {
                    tIndex++;
                }
            }

        }
        if (pIndex == pattern.length()) {
            return tIndex - pIndex;
        }

        return -1;
    }

    /**
     * AAAA -> [0,1,2,3]
     * ABCDE -> [0,0,0,0,0]
     * AABAACAABAA -> [0,1,0,1, 2,0,1,2,3,4,5]
     * AAACAAAAAC -> [0,1,2,0,1,2,3,3,3,4]
     * AAABAAA -> [0,1,2,0,1,2,3]
     *
     * @param pattern
     * @return
     */
    private static int[] computeLongestPrefixSuffix(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; //length of prev longest prefix suffix
        //lps[0] is always 0

        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else { // if (len == 0)
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Assert.assertEquals(matchingIndex("THIS IS A TEST TEXT", "TEST"), 10);
        Assert.assertEquals(matchingIndex("AABAACAADAABAABA", "AABA"), 0);
        Assert.assertEquals("[0, 0, 0, 0, 0, 1]", Arrays.toString(computeLongestPrefixSuffix("CBABAC")));
        Assert.assertEquals("[0, 1, 2, 0, 1, 2, 3]", Arrays.toString(computeLongestPrefixSuffix("AAABAAA")));
    }
}
