package algorithms.backtrack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.



 Example 1:

 Input: nums = [1,2,2]
 Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 Example 2:

 Input: nums = [0]
 Output: [[],[0]]
 */
@Slf4j
public class SubsetsTwo {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        backtrack(out, nums, new ArrayList(), 0);
        return out;
    }

    private void backtrack(List<List<Integer>> out, int[] nums, List<Integer> subset, int first) {
        out.add(new ArrayList<>(subset));
        for(int i = first; i < nums.length; i++) {
            if(i > first && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            log.info(String.format("Top-down: (%s, first: %s)", subset, first));
            backtrack(out, nums, subset, i+1);
            subset.remove(subset.size()-1);
            log.info(String.format("Backtrack: (%s, first: %s)", subset, first));
        }
    }

    public static void main(String[] args) {
        SubsetsTwo subsets = new SubsetsTwo();
        //test-1
        List<List<Integer>> out = subsets.subsets(new int[]{1,2,2});
        Assert.assertEquals(6,out.size());
        log.info(out.toString());

        //test-2
        out = subsets.subsets(new int[]{0});
        Assert.assertEquals(2,out.size());
        log.info(out.toString());
    }
}
