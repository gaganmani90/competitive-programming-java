package problemSolving.dynamic_programming;

import org.junit.Assert;

/**
 * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 * <p>
 * Train tickets are sold in 3 different ways:
 * <p>
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 * <p>
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 * <p>
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * <p>
 * https://leetcode.com/problems/minimum-cost-for-tickets/solution/
 */
public class MinimumCostForTicket {
    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    /**
     * Intuition and Algorithm
     * <p>
     * As in Approach 1, we only need to buy a travel pass on a day we intend to travel.
     * <p>
     * Now, let dp(i) be the cost to travel from day days[i] to the end of the plan. If say,
     * j1 is the largest index such that days[j1] < days[i] + 1, j7 is the largest index such that days[j7] < days[i] + 7, and j30 is the largest index such that days[j30] < days[i] + 30, then we have:
     * <p>
     * \text{dp}(i) = \min(\text{dp}(j1) + \text{costs}[0], \text{dp}(j7) + \text{costs}[1], \text{dp}(j30) + \text{costs}[2])dp(i)=min(dp(j1)+costs[0],dp(j7)+costs[1],dp(j30)+costs[2])
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];

        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k])
                j++;
            ans = Math.min(ans, dp(j) + costs[k]);
        }

        memo[i] = ans;
        return ans;
    }

    /**
     * Iterative approach
     * @param days
     * @param costs
     * @return
     */
    public static int minCostIterative(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        //each index represent current day. Index 0 can be ignored.
        //value of dp array represents cost to travel to that day (index)
        int[] dp = new int[maxDay + 1];
        boolean[] travelDay = new boolean[maxDay + 1]; //true means travel

        for (int i = 0; i < days.length; i++) {
                travelDay[days[i]] = true;
        }

        for (int currDay = 1; currDay < dp.length; currDay++) {
            //did not travel, so carry forward prev cost
            if (!travelDay[currDay]) {
                dp[currDay] = dp[currDay - 1];
            } else {
                int oneDayPass = dp[currDay - 1] + costs[0];
                int sevenDayPass = (currDay - 7) <= 0 ? costs[1] : dp[currDay - 7] + costs[1];
                int thirtyDayPass = (currDay - 30) <= 0 ? costs[2] : dp[currDay - 30] + costs[2];
                dp[currDay] = Math.min(Math.min(oneDayPass,sevenDayPass), thirtyDayPass);
            }
        }
        return dp[maxDay];
    }

    public static void main(String[] args) {
        Assert.assertEquals(new MinimumCostForTicket().minCostIterative(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}), 11);
        Assert.assertEquals(new MinimumCostForTicket().minCostIterative(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}), 17);
        Assert.assertEquals(new MinimumCostForTicket().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}), 11);
        Assert.assertEquals(new MinimumCostForTicket().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}), 17);
    }
}
