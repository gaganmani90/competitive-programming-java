package problemSolving.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/solution/
 * TODO: optimize approach
 */
public class ContiguousArrayOneAndZero {
    /**
     * O(nxn) - bruteforce
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                int len = (j - i + 1);
                if(len%2 == 0 && sum == len/2) { //equal 1s and 0s
                    if(len > maxLength) {
                        maxLength = len;
                    }
                }
            }
        }
        return maxLength;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int findMaxLength_optimized(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
