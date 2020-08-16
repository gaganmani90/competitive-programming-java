package problemSolving.hackerrank.contest;

import org.junit.Assert;

import java.util.Arrays;

/**
 * In universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
 * <p>
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * <p>
 * Given the integer array position and the integer m. Return the required force.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6].
 * The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 * Example 2:
 * <p>
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 */
public class MagneticForceBetweenTwoBalls {
    /**
     * @param position
     * @param totalBalls
     * @return
     */
    public static int maxDistance(int[] position, int totalBalls) {
        int minDistance = 1;
        int len = position.length;
        Arrays.sort(position);
            //binary search
            int low = 0; //not position[0]
            int high = position[len - 1];
            while (low < high) {
                int mid = (low + high) / 2;
                if (isFeasible(position, totalBalls, mid)) {
                    low = mid + 1;
                    minDistance = mid;
                } else {
                    high = mid;
                }
            }

        return minDistance;
    }

    /**
     * @param positions:              available sorted buckets [1,2,3,4,7]
     * @param totalBalls:       number of total balls i.e. 3
     * @param proposedDistance: assumed distance
     * @return
     */
    private static boolean isFeasible(int[] positions, int totalBalls, int proposedDistance) {
        int lastKnownPosition = positions[0]; //put first ball in first bucket
        int placedBalls = 1;

        for (int currBucketIndex = 1; currBucketIndex < positions.length; currBucketIndex++) {
            int currBucketPosition = positions[currBucketIndex];

            if (currBucketPosition - lastKnownPosition >= proposedDistance) {
                //place another ball into this bucket
                lastKnownPosition = currBucketPosition;
                placedBalls++;

                if (placedBalls == totalBalls) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Assert.assertEquals(17, MagneticForceBetweenTwoBalls.maxDistance(new int[]{74, 57, 22}, 3));
        Assert.assertEquals(5, MagneticForceBetweenTwoBalls.maxDistance(new int[]{79, 74, 57, 22}, 4));
        Assert.assertEquals(22, MagneticForceBetweenTwoBalls.maxDistance(new int[]{79, 74, 57, 22}, 3));

        Assert.assertTrue(isFeasible(new int[]{1, 2, 3, 4, 7}, 3, 3));
        Assert.assertFalse(isFeasible(new int[]{1, 2, 3, 4, 7}, 3, 4));
        Assert.assertTrue(isFeasible(new int[]{1, 2, 3, 4, 7}, 3, 2));
        Assert.assertTrue(isFeasible(new int[]{22,57,74,79}, 4, 5));

        Assert.assertEquals(3, MagneticForceBetweenTwoBalls.maxDistance(new int[]{1,2,3,4,7}, 3));
        Assert.assertEquals(999999999, MagneticForceBetweenTwoBalls.maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
        //Assert.assertEquals(5, MagneticForceBetweenTwoBalls.maxDistance(new int[]{79, 74, 57, 22}, 4));
    }
}
