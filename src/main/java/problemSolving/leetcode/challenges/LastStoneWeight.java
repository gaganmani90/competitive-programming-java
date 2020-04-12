package problemSolving.leetcode.challenges;

import java.util.Arrays;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 *     If x == y, both stones are totally destroyed;
 *     If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 *
 * Note:
 *
 *     1 <= stones.length <= 30
 *     1 <= stones[i] <= 1000
 */
public class LastStoneWeight {

    /**
     * O(NxN)
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        int weight = -2; //it means that there are weights remaining
        if(stones.length == 1) {
            return stones[0];
        }
        while(weight == -2) {
            int[] maxIndexes = maxIndexes(stones);
            stones = updateStones(stones, maxIndexes[0], maxIndexes[1]);
            weight = checkBoundaryCondition(stones);
        }
        return weight;
    }

    private static int checkBoundaryCondition(int[] stones) {
        int stoneWeight = -1;
        int count = 0;
        for(int weight : stones) {
            if(weight != -1) { //valid weights
                count++;
                stoneWeight = weight;
            }
        }
        return (count == 0) ? 0 : ((count == 1) ? stoneWeight: -2);
    }
    /**
     *
     * @param stones
     * @return
     */
    private static int[] maxIndexes(int[] stones) {
        int[] max = new int[2];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] != -1){
                if(stones[i] > max1) {
                    //update second max
                    max2 = max1;
                    max[1] = max[0];

                    max1 = stones[i];
                    max[0] = i;
                } else if (stones[i] > max2) {
                    max2 = stones[i];
                    max[1] = i;
                }
            }
        }
        return max;
    }

    /**
     *
     * @param stones
     * @param maxIndex1
     * @param maxIndex2
     * @return
     */
    private static int[] updateStones(int[] stones, int maxIndex1, int maxIndex2) {
        int[] updatedStones = Arrays.copyOf(stones,stones.length);
        if(stones[maxIndex1] == stones[maxIndex2]) {
            updatedStones[maxIndex1] = updatedStones[maxIndex2] = -1;
        } else {
            updatedStones[maxIndex1] = -1;
            updatedStones[maxIndex2] = Math.abs(stones[maxIndex1] - stones[maxIndex2]);
        }
        return updatedStones;

    }
}


