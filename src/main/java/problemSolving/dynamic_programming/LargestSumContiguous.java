package problemSolving.dynamic_programming;

/**
 * Largest Sum Contiguous Subarray
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * Lets take the example:
 * {-2, -3, 4, -1, -2, 1, 5, -3}
 * => {4,-1,-2,1,5} = 7 is the maximum contiguous sum sub-array
 */
public class LargestSumContiguous {

    static int maximumContiguousSum(int[] arr) {

        if(arr == null){
            return -1;
        }

        int maxSumSoFar = arr[0];
        int sumTillNow = arr[0];

        for (int index = 1; index < arr.length; index++) {

            /**
             * Current element can be greater than the sum till now when previous
             * contiguous sum is negavite and current element is positive
             */
            sumTillNow = Math.max(arr[index], sumTillNow + arr[index]);

            if (sumTillNow > maxSumSoFar) {
                maxSumSoFar = sumTillNow;
            }
        }
        return maxSumSoFar;
    }
}
