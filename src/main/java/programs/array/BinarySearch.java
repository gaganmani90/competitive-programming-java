package programs.array;

/**
 * You have a sorted array but it has been shifted. Perform binary search
 *
 * @author gagamani
 * @date 9/20/18
 */
public class BinarySearch {

    /**
     * Normal binary search
     *
     * @param arr : [1,2,3,4,5] sorted array
     * @param x
     * @return
     */
    static int search(int[] arr, int x) {
        return binarySearch(arr, 0, arr.length - 1, x);
    }

    /**
     * TODO: complete this
     *
     * @param arr i.e. [4,1,2,3]
     * @param key
     * @return
     */
    static int search_rotatedArray(int[] arr, int key) {
        return 0;
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
