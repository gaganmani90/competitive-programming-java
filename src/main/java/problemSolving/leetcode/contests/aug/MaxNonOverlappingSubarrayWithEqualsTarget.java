package problemSolving.leetcode.contests.aug;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/contest/weekly-contest-201/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 *
 * Given an array nums and an integer target.
 *
 * Return the maximum number of non-empty non-overlapping subarrays such that the sum of values in each subarray is equal to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 2
 * Output: 2
 * Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).
 * Example 2:
 *
 * Input: nums = [-1,3,5,1,4,2,-9], target = 6
 * Output: 2
 * Explanation: There are 3 subarrays with sum equal to 6.
 * ([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.
 * Example 3:
 *
 * Input: nums = [-2,6,6,3,5,4,1,2,8], target = 10
 * Output: 3
 * Example 4:
 *
 * Input: nums = [0,0,0], target = 0
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 0 <= target <= 10^6
 */
public class MaxNonOverlappingSubarrayWithEqualsTarget {

    public static int maxNonOverlapping(int[] nums, int target) {
        int endIndex = doesSubarrayExist(nums, 0, target);

        // :( bad luck
        if(endIndex == -1) {
            return 0;
        }
        int count = 0;
        while(endIndex != -1) {
            count++;
            endIndex = doesSubarrayExist(nums, endIndex+1, target);
        }
        return count;
    }

    /**
     * This is a subproblem that tells you is a subarray exist with sum of its elements to target.
     * Note that the array may contain negative numbers as well.
     * @param nums
     * @param target
     * @return end index
     */
    private static int doesSubarrayExist(int[] nums, int beginIndex, int target) {
        //stores sum and array index
        Map<Integer, Integer> indexSumMap = new HashMap<>();
        int sum = 0;
        int start = beginIndex, end = -1;
        for(int i = beginIndex; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - target;
            //the sub-array is starting from beginning
            if(diff == 0) {
                start = beginIndex;
                end = i;
                break;
            }

            /**
             * it means that we passed over target hence we need to readjust start index
             */
            if (indexSumMap.containsKey(diff)) {
                start = indexSumMap.get(diff) + 1;
                end = i;
                break;
            }
            indexSumMap.put(sum, i);
        }

        if(end == -1) {
            return -1;
        } else {
            System.out.printf("sum found between %d and %d; %s\n",start, end, Arrays.toString(nums));
        }
        return end;
    }

    public static void main(String[] args) {
        Assert.assertEquals(3,doesSubarrayExist(new int[]{-1,3,5,1,4,2,-9}, 0,6));
        Assert.assertEquals(3,doesSubarrayExist(new int[]{10, 2, -2, -20, 10}, 0,-10));

        Assert.assertEquals("There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).",
                2, maxNonOverlapping(new int[]{1,1,1,1,1}, 2));

        Assert.assertEquals("([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping",
                2, maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6));

        Assert.assertEquals(3, maxNonOverlapping(new int[]{-2,6,6,3,5,4,1,2,8}, 10));
        Assert.assertEquals(3, maxNonOverlapping(new int[]{0,0,0}, 0));
    }
}
