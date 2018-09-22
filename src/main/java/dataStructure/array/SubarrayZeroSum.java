package dataStructure.array;

import java.util.HashSet;

/**
 * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
 */
public class SubarrayZeroSum {

    public static boolean isZeroSumSubarray(int[] arr){
        int sum;
        for(int i = 0; i < arr.length; i++){
            sum = arr[i];
            if(sum == 0){
                return true;
            }
            for(int j = i+1; j < arr.length; j++){
                sum += arr[j];
                if(sum == 0){
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * O(n)
     * @param arr
     * @return
     */
    public static boolean isZeroSumSubarray_optimized(int[] arr){
        HashSet<Integer> elementsSoFar = new HashSet<>();
        int sumSoFar = 0;

        for(int i=0; i<arr.length; i++){
            int currElement = arr[i];
            sumSoFar += currElement;

            //check if sum exists in hashset
            if(elementsSoFar.contains(sumSoFar) || (sumSoFar == 0 && i!=0) || currElement == 0){
                return true;
            }

            elementsSoFar.add(sumSoFar);
        }

        return false;

    }
}
