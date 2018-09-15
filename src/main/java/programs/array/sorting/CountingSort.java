package programs.array.sorting;

import java.util.Arrays;

/**
 * Sort when range is known
 * i.e. sort an array withing a range of 0 to 10 {3,3,4,2,1}
 */
public class CountingSort {

    public static String sort(int[] arr){
        int[] output = new int[arr.length];
        int[] count = new int[255];

        /**
         * increase count of occurring int
         */
        for(int index = 0; index < arr.length; index++){
            int num = arr[index];
            count[num] = count[num] + 1;
        }

        //create exact positions
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int index = 0; index < arr.length; index++){
                output[count[arr[index]]-1] = arr[index];
                --count[arr[index]];
        }

        return Arrays.toString(output);
    }
}
