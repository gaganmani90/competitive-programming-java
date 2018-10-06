package problemSolving.dynamic_programming;

/**
 * We have discussed Overlapping Subproblems and Optimal Substructure properties.
 * <p>
 * Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {

    private int longestCommSub[];
    private int input[];

    public LongestIncreasingSubsequence(int[] arr) {
        this.longestCommSub = new int[arr.length];

        //initialize with 1
        for (int ind = 0; ind < arr.length; ind++) {
            longestCommSub[ind] = 1;
        }
        this.input = arr;
    }

    /**
     * count of longest common sub sequence
     * @return
     */
    int longestCommonSubsequence() {

        if (input.length == 1) {
            return 1;
        }

        //fill longest subsequence array for each element
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * Increase LIS count only if 1) it is in increasing order
                 * 2) LIS count is lesser or equal to the previous LIS count
                 * i.e. [10,22,9,33] -> [1,2,1,1]
                 * Now you don't wanna increase index 4 for [9] because LIS for 9 is 1
                 */
                if (input[i] > input[j] && longestCommSub[j] >= longestCommSub[i]) {
                    longestCommSub[i] += 1;
                }
            }
        }

        return maxLIS(longestCommSub);
    }

    private static int maxLIS(int[] lis) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }


}
