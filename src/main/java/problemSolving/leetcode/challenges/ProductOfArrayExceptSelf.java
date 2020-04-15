package problemSolving.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any
 * prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    /**
     * O(N)
     * space: O(M): M = number of zeros
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        List<Integer> zeros = new ArrayList<>();

        if(nums.length == 1) {
            return nums;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeros.add(i);
                continue;
            }
            product *= nums[i];
        }
        if(zeros.size() > 1) { //more than 1 0s will result in all 0 array
            Arrays.fill(nums, 0);
            return nums; //all 0s
        } else if(zeros.size() == 1) {
            Arrays.fill(nums, 0);
            nums[zeros.get(0)] = product;
            return nums;
        }
        for(int i = 0; i < nums.length; i++) {
                nums[i] = product/nums[i];
        }
        return nums;
    }
}
