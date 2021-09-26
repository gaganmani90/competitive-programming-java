package algorithms.backtrack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
@Slf4j
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        backtrack(response, nums, new ArrayList());
        log.info(response.toString());
        return response;
    }

    private void backtrack(List<List<Integer>> out, int[] nums, List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            out.add(new ArrayList<>(tempList));
            log.info("result found: "+tempList);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; //skip if already exist
                tempList.add(nums[i]);
                log.debug(String.format("Top-down: (%s, index: %s)", tempList, i));
                backtrack(out, nums, tempList);
                tempList.remove(tempList.size() - 1);
                log.debug(String.format("Backtrack: (%s, index: %s)", tempList, i));
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        List<List<Integer>> out = permutations.permute(new int[]{1,2,3});
        Assert.assertEquals(6, out.size());
    }
}
