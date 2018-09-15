package programs.array;

import java.util.Arrays;

/**
 * @author gagamani
 * @date 9/15/18
 */
public class MergeSortedArrays {

    static int[] mergeByInsertion(int[] arr1, int[] arr2){
        int[] sortedArray = new int[arr1.length+arr2.length];

        sortedArray = Arrays.copyOf(arr1, sortedArray.length);
        return sortedArray;
    }
}
