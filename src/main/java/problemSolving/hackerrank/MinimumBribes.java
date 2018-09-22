package problemSolving.hackerrank;

import java.util.Arrays;

//WRONG SOLUTION
public class MinimumBribes {

    public static int minimumBribes(int[] arr) {
        int bribeCount = 0;

        int[] copy = Arrays.copyOf(arr, arr.length);
        int[] diff = new int[copy.length];
        Arrays.sort(copy);

        for (int i = 0; i < copy.length; i++) {
            diff[i] = (arr[i] - copy[i]);
        }

        for (int currNumber : diff) {
            if (currNumber > 2) {
                System.out.print("Too chaotic");
                bribeCount = 0;
                break;
            }
            if (currNumber > 0) {
                bribeCount += currNumber;
            }
        }
        return bribeCount;
    }
}
