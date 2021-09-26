package algorithms.backtrack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 *
 Given a collection of numbers, nums, that might contain duplicates,
 return all possible unique permutations in any order.



 Example 1:

 Input: nums = [1,1,2]
 Output:
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 Example 2:

 Input: nums = [1,2,3]
 Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
@Slf4j
public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        backtrack(response, nums, new ArrayList(), new boolean[nums.length]);
        log.info(response.toString());
        return response;
    }

    private void backtrack(List<List<Integer>> out, int[] nums,
                           List<Integer> tempList, boolean[] used) {
        if(tempList.size() == nums.length) {
            out.add(new ArrayList<>(tempList));
            log.info("result found: "+tempList);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                log.debug(String.format("Top-down: (%s, index: %s)", tempList, i));
                backtrack(out, nums, tempList, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
                log.debug(String.format("Backtrack: (%s, index: %s)", tempList, i));
            }
        }
    }

    public static void main(String[] args) {
        PermutationsTwo permutations = new PermutationsTwo();

        List<List<Integer>> out = permutations.permuteUnique(new int[]{1,1,3});
        Assert.assertEquals(3, out.size());
    }
}
