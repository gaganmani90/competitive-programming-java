package dataStructure.array.matrix;

/**
 * Given a  2D Array, :
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:
 * <p>
 * a b c
 * d
 * e f g
 * There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
 * <p>
 * For example, given the 2D array:
 * <p>
 * -9 -9 -9  1 1 1
 * 0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 * 0  0  8  6 6 0
 * 0  0  0 -2 0 0
 * 0  0  1  2 4 0
 * We calculate the following  hourglass values:
 * <p>
 * -63, -34, -9, 12,
 * -10, 0, 28, 23,
 * -27, -11, -2, 10,
 * 9, 17, 25, 18
 * Our highest hourglass value is  from the hourglass:
 * <p>
 * 0 4 3
 * 1
 * 8 6 6
 * Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.
 * <p>
 * Function Description
 * <p>
 * Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.
 * <p>
 * hourglassSum has the following parameter(s):
 * <p>
 * arr: an array of integers
 * Input Format
 * <p>
 * Each of the  lines of inputs  contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the largest (maximum) hourglass sum found in .
 * <p>
 * Sample Input
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 * <p>
 * 19
 * Explanation
 * <p>
 * contains the following hourglasses:
 * <p>
 * image
 * <p>
 * The hourglass with the maximum sum () is:
 * <p>
 * 2 4 4
 * 2
 * 1 2 4
 *
 * @author gaganmani
 * @date 17/10/18
 * @package dataStructure.array.matrix
 */
public class HourglassSum {

    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < arr.length - 2; row++) {
            for (int col = 0; col < arr[0].length - 2; col++) {
                int sum = oneHourglassSum(row, col, arr);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

        }

        return maxSum;

    }

    /**
     * 3x3 matrix
     *
     * @param arr
     * @return
     */
    private static int oneHourglassSum(int startRow, int startCol, int[][] arr) {
        int sum = 0;
        for (int row = startRow; row <= startRow + 2; row++) {
            if (row != startRow + 1) {
                sum += arr[row][startCol] + arr[row][startCol + 1] + arr[row][startCol + 2];
            } else {
                sum += arr[row][startCol + 1];
            }
        }
        return sum;
    }
}
