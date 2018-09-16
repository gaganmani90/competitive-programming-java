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

    static int[] byMergeSort(int[] arr1, int[] arr2){
        int[] sortedArray = new int[arr1.length+arr2.length];

        int l = 0;
        int r = 0;
        int i = 0;

        while(l < arr1.length && r < arr2.length){
            if(arr1[l] < arr2[r]){
                sortedArray[i] = arr1[l];
                l++;
            }
            else{
                sortedArray[i] = arr2[r];
                r++;
            }
            i++;
        }

        //add remaining items
        while(i < sortedArray.length){
            if(l < arr1.length){
                sortedArray[i] = arr1[l];
                l++;
            }
            if(r < arr2.length){
                sortedArray[i] = arr2[r];
                r++;
            }
            i++;
        }

        return sortedArray;
    }


}
