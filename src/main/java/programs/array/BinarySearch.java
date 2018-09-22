package programs.array;

/**
 * You have a sorted array but it has been shifted. Perform binary search
 *
 * @author gagamani
 * @date 9/20/18
 */
public class BinarySearch {

    enum SearchType {
        ITERATIVE, RECURSIVE;
    }

    /**
     * Normal binary search
     *
     * @param arr : [1,2,3,4,5] sorted array
     * @param x
     * @return
     */
    static int search(int[] arr, int x, SearchType searchType) {
        switch (searchType) {
            case ITERATIVE:
                return binarySearch_iterative(arr, 0, arr.length - 1, x);
            case RECURSIVE:
                return binarySearch(arr, 0, arr.length - 1, x);
            default:
                return -1;
        }
    }


    /**
     * Finds minimum element from rotated sorted array
     *
     * @param arr i.e. [5,1,2,3,4]; [4,5,6,7,8,1,2,3]
     * @return
     */
    static int findMinimum(int[] arr) {
        return minUtil(arr, 0, arr.length - 1);
    }

    /**
     * Searches rotated sorted array by using modified version of
     * binary search
     *
     * @param arr i.e. [4,1,2,3]
     * @param key
     * @return returns index of searched element or -1 if not found
     */
    static int searchRotatedArray(int[] arr, int key) {
        return searchRotationUtil(arr, 0, arr.length - 1, key);
    }

    private static int searchRotationUtil(int[] arr, int low, int high, int key) {
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return arr[low] == key ? low : -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        /**
         * search in right half of the array if the following conditions are met
         */
        if ((arr[mid] < key && arr[high] > arr[mid]) || (arr[mid] > key && arr[high] < arr[mid])) {
            return searchRotationUtil(arr, mid + 1, high, key);
        }
        return searchRotationUtil(arr, low, mid - 1, key);
    }


    private static int minUtil(int[] arr, int low, int high) {
        if (high < low)
            return arr[0];
        if (high == low) {
            return arr[low];
        }
        int mid = (low + high) / 2;

        //check if next element is the min i.e. [4,5,6,7,8,1,2,3]
        if (mid < high && arr[mid + 1] < arr[mid]) {
            return arr[mid + 1];
        }

        //check if mid itself  is the min i.e. [4,1,2,3]
        if (mid > low && arr[mid - 1] > arr[mid]) {
            return arr[mid];
        }

        /**
         * Decide whether we need to go to left half or right half
         * Examples:
         * [4,5,6,7,1,2,3], mid element = 7, it will go right
         * [9,1,2,3,4,5,6,7,8], mid element = 4, it will go left
         */
        if (arr[high] > arr[mid])
            return minUtil(arr, low, mid - 1);
        return minUtil(arr, mid + 1, high);


    }


    /**
     * Iterative binary search
     *
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    private static int binarySearch_iterative(int[] arr, int left, int right, int key) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) { //ignore first half
                left = mid + 1;
            } else if (arr[mid] > key) {
                right = mid - 1;
            }
        }

        return -1;

    }

    /**
     * @param arr
     * @param left
     * @param right
     * @param key:  element to search
     * @return index of element
     */
    private static int binarySearch(int[] arr, int left, int right, int key) {
        if (left <= right) {

            int mid = (left + right) / 2;
            int x = arr[mid];

            if (x == key) {
                return mid;
            }
            //it means element would be found in left of array
            if (x > key) {
                return binarySearch(arr, left, mid - 1, key);
            } else if (x < key) {
                return binarySearch(arr, mid + 1, right, key);
            }
        }
        return -1;
    }

}
