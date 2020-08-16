package problemSolving.hackerrank.contest;

import com.google.common.base.Stopwatch;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 5490. Minimum Number of Days to Eat N Oranges
 * User Accepted:12
 * User Tried:37
 * Total Accepted:12
 * Total Submissions:48
 * Difficulty:Hard
 * There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:
 *
 * Eat one orange.
 * If the number of remaining oranges (n) is divisible by 2 then you can eat  n/2 oranges.
 * If the number of remaining oranges (n) is divisible by 3 then you can eat  2*(n/3) oranges.
 * You can only choose one of the actions per day.
 *
 * Return the minimum number of days to eat n oranges.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: You have 10 oranges.
 * Day 1: Eat 1 orange,  10 - 1 = 9.
 * Day 2: Eat 6 oranges, 9 - 2*(9/3) = 9 - 6 = 3. (Since 9 is divisible by 3)
 * Day 3: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1.
 * Day 4: Eat the last orange  1 - 1  = 0.
 * You need at least 4 days to eat the 10 oranges.
 * Example 2:
 *
 * Input: n = 6
 * Output: 3
 * Explanation: You have 6 oranges.
 * Day 1: Eat 3 oranges, 6 - 6/2 = 6 - 3 = 3. (Since 6 is divisible by 2).
 * Day 2: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. (Since 3 is divisible by 3)
 * Day 3: Eat the last orange  1 - 1  = 0.
 * You need at least 3 days to eat the 6 oranges.
 * Example 3:
 *
 * Input: n = 1
 * Output: 1
 * Example 4:
 *
 * Input: n = 56
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2*10^9
 */
public class MinDaysToEatOranges {
    Map<Integer, Integer> dp = new HashMap<>();

    /**
     * As pleasant as it seems, it does not make sense to eat oranges one by one.
     *
     * So, the choice we have is to eat n % 2 oranges one-by-one and then swallow n / 2, or eat n % 3 oranges so that we can gobble 2 * n / 3.
     *
     * As usual, we use DP to avoid re-computation. Since our numbers can be large, it's better to use a hash map instead of an array.
     * @param n
     * @return
     */
    public int minDays(int n) {
        if (n <= 1)
            return n;
        if (!dp.containsKey(n))
            dp.put(n, 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)));
        return dp.get(n);
    }

    public static void main(String[] args) {
        Stopwatch timer = Stopwatch.createUnstarted();
        timer.start();
        Assert.assertEquals(6, new MinDaysToEatOranges().minDays(60));
        timer.stop();
        System.out.println("method took: "+timer);
        Assert.assertEquals(4, new MinDaysToEatOranges().minDays(10));
    }
}
