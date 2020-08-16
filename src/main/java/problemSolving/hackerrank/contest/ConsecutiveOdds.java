package problemSolving.hackerrank.contest;

import org.junit.Assert;

/**
 * Weekly Contest 202
 */
public class ConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length <= 2) {
            return false;
        } else {
            int count = 0;
            for (int curr : arr) {

                if (curr % 2 != 0) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Assert.assertTrue(ConsecutiveOdds.threeConsecutiveOdds(new int[]{1, 1, 1}));
        Assert.assertFalse(ConsecutiveOdds.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        Assert.assertTrue(ConsecutiveOdds.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }
}
