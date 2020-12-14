package problemSolving.dynamic_programming;

import org.junit.Assert;

public class MinCostClimbingStairs {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int minCost = 0;
        int n = cost.length;
        dp = new int[n];

        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return cost[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
        return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        Assert.assertEquals("recursive", 15, minCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals("recursive", 6,
                minCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
