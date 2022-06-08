package dataStructure.graph.union_find;

import org.junit.Assert;

import java.util.Arrays;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        Assert.assertEquals(2, NumberOfProvinces.countProvinces(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));

        Assert.assertEquals(3, NumberOfProvinces.countProvinces(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }

    /**
     * O(n3) We traverse over the complete matrix once. Union and find operations take
     * O(n) time in the worst case.
     *
     * @param isConnected
     * @return
     */
    public static int countProvinces(int[][] isConnected) {
        int count = 0;
        int[] parents = createDisjointSets(isConnected);

        //count disjointed sets
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                count++;
            }
        }

        return count;
    }

    private static int[] createDisjointSets(int[][] isConnected) {
        int[] parents = new int[isConnected.length];
        Arrays.fill(parents, -1);

        //create disjointed sets
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                //if directly connected
                if (isConnected[i][j] == 1 && i != j) {
                    UnionFindUtil.union(parents, i, j);
                }
            }
        }
        return parents;
    }
}
