package algorithms;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given positive integers n and target.
 *
 * An array nums is beautiful if it meets the following conditions:
 *
 * nums.length == n.
 * nums consists of pairwise distinct positive integers.
 * There doesn't exist two distinct indices, i and j, in the range [0, n - 1], such that nums[i] + nums[j] == target.
 * Return the minimum possible sum that a beautiful array could have.
 */
public class MinPossibleSum {
    public static long minimumPossibleSum(int n, int target) {
        if(n == 1 && target == 1) {
            return 1;
        }
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        int count = 1;
        while(count <= target) {
            if(!set.contains(Math.abs(target-count))) {
                set.add(count);
                sum += count;
            }
            if(set.size() == n) break;
            count++;
        }
        while(set.size() != n) {
            sum = sum + count;
            set.add(count);
            count++;
        }
        return sum;
    }

    public static void main(String[] args) {
       // Assert.assertEquals(MinPossibleSum.minimumPossibleSum(2, 3), 4);
        Assert.assertEquals(MinPossibleSum.minimumPossibleSum(3, 3), 8);
       // Assert.assertEquals(MinPossibleSum.minimumPossibleSum(1, 1), 1);
    }
}
