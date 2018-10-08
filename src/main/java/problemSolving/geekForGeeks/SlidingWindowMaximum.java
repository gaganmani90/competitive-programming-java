package problemSolving.geekForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: Optimize
 * <pre>
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 *
 * Examples :
 *
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 *
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 * </pre>
 *
 * @author gagamani
 * @date 9/23/18
 */
public class SlidingWindowMaximum {

    static String slidingMaxArray(int[] arr, int windowSize) {

        if (windowSize >= arr.length) {
            return Arrays.toString(arr);
        }
        List<Integer> max = new ArrayList<>();

        int index = 0;

        while (index != (arr.length - windowSize + 1)) {
            int[] window = new int[windowSize];
            for (int i = 0, j = index; i < windowSize; i++) {
                window[i] = arr[i + j];
            }
            max.add(max(window));
            index++;
        }

        return max.toString();

    }

    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
