package problemSolving.general.bitwise;

/**
 * Given an integer array of n integers, find sum of bit differences in all pairs that can be formed from array elements. Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
 For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).
 *
 *
 * Examples :

 Input: arr[] = {1, 2}
 Output: 4
 All pairs in array are (1, 1), (1, 2)
 (2, 1), (2, 2)
 Sum of bit differences = 0 + 2 +
 2 + 0
 = 4

 Input:  arr[] = {1, 3, 5}
 Output: 8
 All pairs in array are (1, 1), (1, 3), (1, 5)
 (3, 1), (3, 3) (3, 5),
 (5, 1), (5, 3), (5, 5)
 Sum of bit differences =  0 + 1 + 1 +
 1 + 0 + 2 +
 1 + 2 + 0
 = 8


 *
 *
 * @author gagamani
 * @date 9/10/18
 */
public class SumBitDifference {

    static int bitDifference(int a, int b){
        int xorResult =  a ^ b;

        //count num of set bits
        return CountSetBits.bits(xorResult);
    }

    /**
     * Non-optimized solution O(n2)
     * @param arr
     * @return
     */
    static int sumOfAllPairsBitDiff(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                count += bitDifference(arr[i], arr[j]);
            }
        }
        return count;
    }
}
