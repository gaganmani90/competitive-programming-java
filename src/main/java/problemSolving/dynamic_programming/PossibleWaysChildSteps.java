package problemSolving.dynamic_programming;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
 * 3 steps at a time. Implement a method to count how many possible ways the child
 * can run up the stairs.
 */
public class PossibleWaysChildSteps {

    Map<Integer, Integer> waysCache = new HashMap<>();

    /**
     * Top down
     * O(3^N)
     * since each call branches out to three more calls. This means that countWays
     * is called many times for the same values, which is unnecessary. We can fix this through
     * dynamic programming.
     *
     * @param steps
     * @return
     */
    public static int countWays(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else {
            return countWays(steps - 1) + countWays(steps - 2) + countWays(steps - 3);
        }
    }

    /**
     * DP with cache
     * @param steps
     * @return
     */
    public int countWaysDp(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else if (waysCache.containsKey(steps)) {
            return waysCache.get(steps);
        } else {
            waysCache.put(steps, countWays(steps - 1) + countWays(steps - 2) + countWays(steps - 3));
            return waysCache.get(steps);
        }
    }


    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        Assert.assertEquals(4, countWays(3));
        Assert.assertEquals(4, new PossibleWaysChildSteps().countWaysDp(3));

        watch.start();
        Assert.assertEquals(274, new PossibleWaysChildSteps().countWays(10));
        watch.stop();
        System.out.println("Non-dp time: "+ watch.getNanoTime());

        watch.reset();
        watch.start();
        Assert.assertEquals(274, new PossibleWaysChildSteps().countWaysDp(10));
        watch.stop();
        System.out.println("DP time: "+ watch.getNanoTime());
    }
}
