package problemSolving.binary_search;

import org.junit.Assert;
import utility.Timer;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/**
 * LC Medium
 * <p>
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * <p>
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInMatrix {
    /**
     * O(n*n)
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        Timer.start();
        int n = matrix.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;

        if (k == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                heap.add(matrix[i][j]);
            }
        }

        while (++count != k) {
            heap.poll();
        }
        Timer.stop();
        Timer.print(TimeUnit.MICROSECONDS);

        return heap.poll();
    }


    /**
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_binarySearch(int[][] matrix, int k) {
        Timer.start();
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {

            int mid = start + (end - start) / 2;
            // first number is the smallest and the second number is the largest
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};

            int count = countLessEquals(matrix, mid, smallLargePair);

            if (count == k) {
                start = smallLargePair[0];
                break;
            }

            if (count < k) start = smallLargePair[1]; // search higher
            else end = smallLargePair[0]; // search lower
        }
        Timer.stop();
        Timer.print(TimeUnit.MICROSECONDS);
        return start;
    }

    /**
     * Counts number of elements that is smaller than mid.
     * <p>
     * This method is optimized to utilize sorting property of 2D array.
     *
     * @param matrix
     * @param mid:   this is binary search mid element
     * @return
     */
    private int countLessEquals(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;

        while (row >= 0 && col < n) {

            if (matrix[row][col] > mid) {

                // as matrix[row][col] is bigger than the mid, let's keep track of the
                // smallest number greater than the mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;

            } else {

                // as matrix[row][col] is less than or equal to the mid, let's keep track of the
                // biggest number less than or equal to the mid
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Assert.assertEquals("runtime: 463 MICROSECONDS", 13, kthSmallest(array, 8));
        Assert.assertEquals("runtime: 48 MICROSECONDS", 13, new KthSmallestElementInMatrix().kthSmallest_binarySearch(array, 8));
        //Assert.assertEquals("6 elements smaller or equal than 13", 8, new KthSmallestElementInMatrix().countLessEquals(array, 13));

    }
}
