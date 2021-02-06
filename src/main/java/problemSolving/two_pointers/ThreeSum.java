package problemSolving.two_pointers;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {

    /***
     * Using two pointers approach
     * @param nums
     *
     * O(n2)
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 3) {
            return out;
        }
        //nums[i] <= 0: since this would be the start index, it must be less than 0
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            //skip if value is same as previous (unique triplets remember)
            if (i == 0 || nums[i - 1] != nums[i]) {
                findThreeSumInSubArray(i, nums, out);
            }
        }
        return out;
    }

    /**
     * At his point, assume that startIndex value can never be 0.
     *
     * @param startIndex
     * @param nums
     * @param out
     */
    private void findThreeSumInSubArray(int startIndex, int[] nums, List<List<Integer>> out) {
        int a = nums[startIndex];
        int lo = startIndex + 1; //next to start
        int hi = nums.length - 1; // max len

        while (lo < hi) {
            int b = nums[lo];
            int c = nums[hi];
            int sum = a + b + c;
            if (sum == 0) {
                out.add(Lists.newArrayList(a, b, c));
                //move both the pointers
                lo++;
                hi--;
                //make sure that we are avoiding duplicates, (unique triplets remember)
                //moving any one index will do.
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            } else if (sum < 0) { //need to increase value in sorted array
                lo++;
            } else if (sum > 0) { //reduce value in sorted array
                hi--;
            }
        }
    }


    public static void main(String[] args) {
        Assert.assertEquals(Lists.newArrayList(
                Lists.newArrayList(-1, -1, 2),
                Lists.newArrayList(-1, 0, 1)),
                new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

        Assert.assertEquals(Lists.newArrayList(
                Lists.newArrayList()),
                new ThreeSum().threeSum(new int[]{}));

        Assert.assertEquals(Lists.newArrayList(
                Lists.newArrayList()),
                new ThreeSum().threeSum(new int[]{0}));

        Assert.assertEquals(Arrays.asList(Arrays.asList(0, 0, 0)),
                new ThreeSum().threeSum(new int[]{0, 0, 0, 0}));

        Assert.assertEquals(Arrays.asList(Arrays.asList(0, 0, 0)),
                new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
