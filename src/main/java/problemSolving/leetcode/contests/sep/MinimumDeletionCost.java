package problemSolving.leetcode.contests.sep;

import org.junit.Assert;

/**
 * 5509. Minimum Deletion Cost to Avoid Repeating Letters
 * User Accepted:2180
 * User Tried:2585
 * Total Accepted:2206
 * Total Submissions:3579
 * Difficulty:Medium
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the character i in s.
 * <p>
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 * <p>
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 * Example 2:
 * <p>
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 * Example 3:
 * <p>
 * Input: s = "aabaa", cost = [1,2,3,4,1]
 * Output: 2
 * Explanation: Delete the first and the last character, getting the string ("aba").
 * <p>
 * <p>
 * Constraints:
 * <p>
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s contains only lowercase English letters.
 * <p>
 * https://leetcode.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
public class MinimumDeletionCost {
    public static int minCost(String s, int[] cost) {
        int totalCost = 0;
        int max = Integer.MIN_VALUE;
        int duplicateIndex = 0;
        int c = s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            boolean isSame = false;
            c = s.charAt(i);
            //until characters are similar
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                max = Math.max(max, Math.max(cost[i], cost[i + 1]));
                totalCost += cost[i];
                i++;
                isSame = true;
            }
            //remove max cost from total && add the last cost which was not added in while loop
            //only do it when similarity was found
            if (isSame) {
                totalCost = totalCost - max + cost[i]; //remove the max cost
            }
            max = Integer.MIN_VALUE; //reset
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Assert.assertEquals(3, minCost("aaa", new int[]{1, 2, 3}));
        Assert.assertEquals(3, minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, minCost("abc", new int[]{1, 2, 3}));
        Assert.assertEquals(2, minCost("aabaa", new int[]{1, 2, 3, 4, 1}));

    }
}
