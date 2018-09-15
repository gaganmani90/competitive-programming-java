package programs.array;

import java.util.Arrays;

/**
 * @author gagamani
 * @date 9/15/18
 */
public class MergeSortedArrays {

    /**
     * By using insertion sort
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] mergeByInsertion(int[] arr1, int[] arr2){
        int[] sortedArray = new int[arr1.length+arr2.length];

        sortedArray = Arrays.copyOf(arr1, sortedArray.length);


        for(int i = 0, j = arr1.length-1; i < arr2.length; i++,j++){
            int key = arr2[i];
            int tempIndex = j;
            while (tempIndex >= 0 && sortedArray[tempIndex] > key){
                sortedArray[tempIndex+1] = sortedArray[tempIndex];
                tempIndex = tempIndex - 1;
            }
            sortedArray[tempIndex+1] = key;
        }
        return sortedArray;
    }
}
