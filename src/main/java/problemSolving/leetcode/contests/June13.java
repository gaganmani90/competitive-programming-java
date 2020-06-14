package problemSolving.leetcode.contests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The class contains three problems from 13th June challenge
 */
public class June13 {
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        return sums;
    }

    /**
     * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [5,5,4], k = 1
     * Output: 1
     * Explanation: Remove the single 4, only 5 is left.
     * Example 2:
     * Input: arr = [4,3,1,1,3,3,2], k = 3
     * Output: 2
     * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
     * @param arr
     * @param k
     * @return
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> valueMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            valueMap.merge(arr[i], 1, Integer::sum);
        }

        //System.out.println(valueMap);

        Map<Integer, Integer> sortedMap = valueMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Iterator<Map.Entry<Integer, Integer>> iter = sortedMap.entrySet().iterator();
        while(k != 0 && iter.hasNext()) {
           Map.Entry<Integer, Integer> entry =  iter.next();
           int val = entry.getValue();
           if (k >= val) {
               k = k - val;
               sortedMap.put(entry.getKey(), 0);
           }
        }


        int out = sortedMap.entrySet().stream()
                .filter(x -> x.getValue() > 0).mapToInt(x -> 1).sum();
        return out;

    }

    /**
     * Problem - 3 [binary search]
     * O(N*log(Max_Integer))
     *
     * Given an integer array bloomDay, an integer m and an integer k.
     *
     * We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
     *
     * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
     *
     * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
     * Output: 3
     * Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
     * We need 3 bouquets each should contain 1 flower.
     * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
     * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
     * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
     * Example 2:
     *
     * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
     * Output: -1
     * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
     * Example 3:
     *
     * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
     * Output: 12
     * Explanation: We need 2 bouquets each should have 3 flowers.
     * Here's the garden after the 7 and 12 days:
     * After day 7: [x, x, x, x, _, x, x]
     * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
     * After day 12: [x, x, x, x, x, x, x]
     * It is obvious that we can make two bouquets in different ways.
     * Example 4:
     *
     * Input: bloomDay = [1000000000,1000000000], m = 1, k = 1
     * Output: 1000000000
     * Explanation: You need to wait 1000000000 days to have a flower ready for a bouquet.
     * Example 5:
     *
     * Input: bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
     * Output: 9
     * @param bloomDay
     * @param numberOfBouq: num of required bouquets
     * @param flowersInOneBouq: num of flowers
     * @return
     */
    public int minDays(int[] bloomDay, int numberOfBouq, int flowersInOneBouq) {
        int low = 1; //lowest number of days
        int high = Integer.MAX_VALUE; //max number of days

        if(numberOfBouq*flowersInOneBouq > bloomDay.length) {
            return -1;
        }

        while (high > low) {
            int mid = (low + high) / 2, flowers = 0, bouq = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if(bloomDay[i] > mid) { //flower can not bloom, it breaks the adjacency
                    flowers = 0;
                } else if (++flowers >= flowersInOneBouq) {
                    bouq++;
                    flowers = 0; //reset
                }
            }

            if (bouq < numberOfBouq) { //if num of bouq is still less than required
                low = mid + 1;
            } else {
                high = mid; //keep squeezing the binary search array to find out the min no of days
            }
        }
        return low;
    }


    public static void main(String[] args) {
        June13 sc = new June13();

        //int ans = sc.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3);
        //System.out.println(ans);

        int min  = sc.minDays(new int[]{5,37,55,92,22,52,31,62,99,64,92,53,34,84,93,50,28}, 8,2);
        System.out.println(min);
    }
}
