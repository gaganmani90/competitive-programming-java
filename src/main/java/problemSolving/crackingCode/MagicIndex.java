package problemSolving.crackingCode;

import org.junit.Assert;

/**
 * A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if
 * one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex {

    public static int magicIndex_bf(int[] arr) {
        int index = 0;
        for (int curr : arr) {
            if (curr == index) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int magicIndex_binarySearch(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] > mid) {
                hi = mid;
            } else if (arr[mid] < mid) {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static int magicFast(int[] arr) {
        return magicFast(arr, 0, arr.length - 1);
    }

    private static int magicFast(int[] arr, int lo, int hi) {
        if (hi < lo || lo < 0 || hi >= arr.length) {
            return -1;
        }
        int midIndex = (hi + lo) / 2;
        int midValue = arr[midIndex];

        if (midIndex == midValue) {
            return midIndex;
        }

        //Search left
        int left = magicFast(arr, lo, Math.min(midIndex - 1, midValue));
        if (left >= 0) {
            return left;
        }

        //search right
        int right = magicFast(arr, Math.max(midIndex + 1, midValue), hi);

        return right;
    }

    public static void main(String[] args) {
        //O(n)
        Assert.assertEquals(0, magicIndex_bf(new int[]{0, 1, 2, 3, 4, 5}));
        Assert.assertEquals(2, magicIndex_bf(new int[]{-40, -20, 2, 3, 4}));

        //O(logn) but will not work when duplicate elements
        Assert.assertEquals(7, magicIndex_binarySearch(new int[]{-10, -5, -2, 2, 2, 3, 4, 7, 9, 12, 13}));
        Assert.assertEquals(2, magicIndex_binarySearch(new int[]{0, 1, 2, 3, 4, 5}));
        Assert.assertEquals(2, magicIndex_binarySearch(new int[]{-40, -20, 2, 3, 4}));
        Assert.assertEquals(4, magicIndex_binarySearch(new int[]{-40, -20, -10, 2, 4}));
        //Assert.assertEquals("will not work", 4, magicIndex_binarySearch(new int[]{-40, -20, -10, 4, 4}));

        //O(logn)
        Assert.assertEquals(7, magicFast(new int[]{-10, -5, -2, 2, 2, 3, 4, 7, 9, 12, 13}));
        Assert.assertEquals(2, magicFast(new int[]{0, 1, 2, 3, 4, 5}));
        Assert.assertEquals(2, magicFast(new int[]{-40, -20, 2, 3, 4}));
        Assert.assertEquals(4, magicFast(new int[]{-40, -20, -10, 2, 4}));
    }
}
