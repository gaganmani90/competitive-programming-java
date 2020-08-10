package problemSolving.dynamic_programming;


import org.junit.Assert;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-201/problems/minimum-cost-to-cut-a-stick/
 * <p>
 * Dynamic Programming
 */
public class MinimumCostToCutAStick {
    private int[][] dp;
    private int[] requiredCuts;

    public int minCost(int n, int[] cuts) {
        init(cuts, n);

        return minCostUtil(this.requiredCuts, 0, this.requiredCuts.length - 1);
    }

    /**
     * @param cuts
     * @param low
     * @param high
     * @return
     */
    private int minCostUtil(int[] cuts, int low, int high) {
        if (low + 1 == high) { //if there is no cut between low and high return 0
            return 0;
        } else if (dp[low][high] != -1) { //if solution has been computed, return it
            return dp[low][high];
        } else {
            int ans = Integer.MAX_VALUE;
            for (int i = low + 1; i < high; i++) {
                int curr = cuts[high] - cuts[low] + minCostUtil(cuts, low, i) + minCostUtil(cuts, i, high);
                ans = Math.min(ans, curr);
            }
            dp[low][high] = ans;
            return ans;
        }
    }

    /**
     * TODO: complete bottom up approach
     * refer: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/781085/Python3-top-down-and-bottom-up-dp
     * @param n:    length of stick.
     * @param cuts: unordered array where cuts should be made
     * @return minimum cost by rearranging cuts
     */
    public int minCost_bottomUp(int n, int[] cuts) {
        init(cuts, n);

        return 0;
    }

    /**
     * Initialize dp array and resize input cuts array
     * @param cuts
     * @param n
     */
    private void init(int[] cuts, int n) {
        //initialize dp array
        this.dp = new int[102][102];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        //initialize new array: add 0 and n to new array
        this.requiredCuts = new int[cuts.length + 2];
        this.requiredCuts[0] = 0;
        this.requiredCuts[this.requiredCuts.length - 1] = n;
        for (int i = 0, j = 1; i < cuts.length; i++, j++) {
            this.requiredCuts[j] = cuts[i];
        }
        Arrays.sort(this.requiredCuts);
    }





    public static void main(String[] args) {
        Assert.assertEquals(16, new MinimumCostToCutAStick().minCost(7, new int[]{1, 3, 4, 5}));
        Assert.assertEquals(22, new MinimumCostToCutAStick().minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}
