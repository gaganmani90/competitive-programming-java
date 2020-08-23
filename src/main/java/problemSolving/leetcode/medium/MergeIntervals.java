package problemSolving.leetcode.medium;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/merge-intervals/
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * intervals[i][0] <= intervals[i][1]
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        //contains sorted intervals by starting value.
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int prevStart = -1, prevEnd = -1;
        Set<int[]> mergedIntervals = new TreeSet<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (prevStart == -1) {
                prevStart = currInterval[0];
                prevEnd = currInterval[1];
            } else {
                //start of curr and prev are same or prev end is greater than curr start
                if (prevStart == currInterval[0] || prevEnd >= currInterval[0]) {
                    prevEnd = prevEnd > currInterval[1] ? prevEnd : currInterval[1];
                } else if (currInterval[0] > prevEnd) { //current start is greater than prev end
                    mergedIntervals.add(new int[]{prevStart, prevEnd});
                    prevStart = currInterval[0];
                    prevEnd = currInterval[1];
                }
            }
            //if last entry
            if (i == intervals.length-1) {
                mergedIntervals.add(new int[]{prevStart, prevEnd});
            }
        }
       // mergedIntervals.stream().forEach(i -> System.out.println(Arrays.toString(i)));
        int[][] out = mergedIntervals.stream().toArray(int[][]::new);
       // Arrays.stream(out).forEach(i -> System.out.println(Arrays.toString(i)));
        return out;
    }


    public static void main(String[] args) {
        Assert.assertTrue(isDeepEquals(new int[][]{{1, 5}}, merge(new int[][]{
                {1, 4}, {1, 5}
        })));
        Assert.assertTrue(isDeepEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, merge(new int[][]{
                {1, 3}, {8, 10}, {2, 6}, {15, 18}
        })));
        Assert.assertTrue(isDeepEquals(new int[][]{{1, 5}}, merge(new int[][]{
                {1, 4}, {4, 5}
        })));
        Assert.assertTrue(isDeepEquals(new int[][]{{1, 4}}, merge(new int[][]{
                {1, 4}
        })));

    }

    private static boolean isDeepEquals(int[][] a, int[][] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] != b[i][0] || a[i][1] != b[i][1]) {
                return false;
            }
        }
        return true;
    }
}
