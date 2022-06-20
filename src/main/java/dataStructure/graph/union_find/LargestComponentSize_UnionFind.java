package dataStructure.graph.union_find;

import org.junit.Assert;

/**
 * You are given an integer array of unique positive integers nums. Consider the following graph:
 *
 * There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
 * There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
 * Return the size of the largest connected component in the graph.
 *
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
public class LargestComponentSize_UnionFind {

    public static int largestComponentSize(int[] nums) {
        int count = 0;

        return count;
    }

    public static void main(String[] args) {
        Assert.assertEquals(4, LargestComponentSize_UnionFind.largestComponentSize(new int[]{4,6,15,35}));
        Assert.assertEquals(2, LargestComponentSize_UnionFind.largestComponentSize(new int[]{20,50,9,63}));
        Assert.assertEquals(8, LargestComponentSize_UnionFind.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
    }
}
