package programs.array;

import java.util.Arrays;

/**
 * @author gagamani
 * @date 9/15/18
 */
public class MergeSortedArrays {

    /**
     * By using insertion sort
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] mergeByInsertion(int[] arr1, int[] arr2) {
        int[] sortedArray = new int[arr1.length + arr2.length];

        sortedArray = Arrays.copyOf(arr1, sortedArray.length);


        for (int i = 0, j = arr1.length - 1; i < arr2.length; i++, j++) {
            int key = arr2[i];
            int tempIndex = j;
            while (tempIndex >= 0 && sortedArray[tempIndex] > key) {
                sortedArray[tempIndex + 1] = sortedArray[tempIndex];
                tempIndex = tempIndex - 1;
            }
            sortedArray[tempIndex + 1] = key;
        }
        return sortedArray;
    }

    /**
     * Another solution by using mergeSort
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] byMergeSort(int[] arr1, int[] arr2) {
        int[] sortedArray = new int[arr1.length + arr2.length];

        int l = 0;
        int r = 0;
        int i = 0;

        while (l < arr1.length && r < arr2.length) {
            if (arr1[l] < arr2[r]) {
                sortedArray[i] = arr1[l];
                l++;
            } else {
                sortedArray[i] = arr2[r];
                r++;
            }
            i++;
        }

        //add remaining items
        while (i < sortedArray.length) {
            if (l < arr1.length) {
                sortedArray[i] = arr1[l];
                l++;
            }
            if (r < arr2.length) {
                sortedArray[i] = arr2[r];
                r++;
            }
            i++;
        }

        return sortedArray;
    }

    /**
     * Merges multiple sorted arrays
     */
    public static class MergeManyArrays{
        /**
         * Merge any number of sorted arrays
         * i.e.
         * {
         * {1,2,3}
         * {4,5,6}
         * {6,7,8}
         * {4,5,6,7,8}
         * }
         *
         * @param arrays
         * @return
         */
        static int[] mergeArrays(int[][] arrays) {
            int[] sortedArray = new int[sizeOfArray(arrays)];

            //copy array[0] to sorted array for initialization
            for(int i = 0; i < arrays[0].length; i++){
                sortedArray[i] = arrays[0][i];
            }
            int endIndex = arrays[0].length - 1;

            //Traverse each array
            for(int i = 1; i < arrays.length; i++){
                //use insertion sort with eac array
                int[] arr = arrays[i];

                //merge 'arr' and 'sortedArray' by insertion sort
                sortedArray = mergeTwoArrays(arr, sortedArray, endIndex);
                endIndex += arr.length;

            }

            return sortedArray;

        }

        /**
         * This magical method merges two arrays by using insertion sort.
         * @param arr sorted array which gets merged in sortedArray
         * @param sortedArray incomplete sorted array which has to adjust with arr in sorted manner
         * @param endIndex index till which values are present in sortedArray. Remaining values after this index will be zeros
         * @return
         */
        private static int[] mergeTwoArrays(int[] arr, int[] sortedArray, int endIndex){
            for(int i = 0; i < arr.length; i++){
                int key = arr[i];
                int j = endIndex;

                while(j >= 0 && sortedArray[j] > key){
                    sortedArray[j+1] = sortedArray[j];
                    j--;
                }
                sortedArray[j+1] = key;
                endIndex++;
            }

            return sortedArray;
        }

        private static int sizeOfArray(int[][] arrays){
            int size = 0;
            for(int i = 0; i < arrays.length; i++){
                size += arrays[i].length;
            }
            return size;
        }
    }




}
