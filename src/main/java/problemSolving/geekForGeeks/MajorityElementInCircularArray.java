package problemSolving.geekForGeeks;

/**
 * https://www.geeksforgeeks.org/majority-element-in-a-circular-array-of-0s-and-1s/
 * <p>
 * <pre>
 *  Given a circular array containing only 0’s and 1’s, of size n where n = p*q (p and q are both odd integers).
 *  The task is to check if there is a way such that 1 will be in majority after applying the following operations:
 *
 * Divide circular array into p subarrays each of size q.
 * In each subarray, the number which is in majority will get stored into array B.
 * Now, 1 will said to be in majority if it is in majority into array B.
 * </pre>
 *
 * @author gagamani
 * @date 9/22/18
 */
public class MajorityElementInCircularArray {

    /**
     * This method will tell if {@code element} is in majority
     * across all sub-arrays
     *
     * @param arr            consists of 1s and 0s
     * @param numOfSubarrays number of sub-arrays
     * @param sizeOfSubarray size of a sub-array
     * @param element        either 1 or 0
     * @return
     */
    static boolean isMajority(int[] arr, int numOfSubarrays, int sizeOfSubarray, int element) {

        //array should equally divide into sub arrays
        if (arr.length % sizeOfSubarray != 0) {
            return false;
        }

        int[] elementCount = new int[numOfSubarrays]; //count of element in each sub array

        int rotationIndex = 0;

        while (rotationIndex != arr.length) {

            int currentIndex = 0; //keeps track of index in main array

            for (int subarrayPosition = 0; subarrayPosition < numOfSubarrays; subarrayPosition++) {
                int[] subArray = new int[sizeOfSubarray];
                //sub array creation
                for (int j = 0, k = currentIndex; j < sizeOfSubarray; j++, currentIndex++) {
                    subArray[j] = arr[(currentIndex + rotationIndex) % arr.length];
                }
                //add element count from the sub array which was created above
                elementCount[subarrayPosition] = getElementCount(subArray, element);
            }

            //check if element is in majority
            if (isElementInMajority(elementCount, sizeOfSubarray)) {
                return true;
            }
            rotationIndex++; //try iterating circular array by next position

        }


        return false;

    }

    /**
     * Utility method to figure out if element wins the majority
     *
     * @param count
     * @param sizeOfSubarray
     * @return
     */
    static boolean isElementInMajority(int[] count, int sizeOfSubarray) {
        int majorityOccurance = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > (sizeOfSubarray - count[i])) {
                majorityOccurance++;
            }
        }

        if (majorityOccurance > (count.length - majorityOccurance)) {
            return true;
        } else {
            return false;
        }
    }

    private static int getElementCount(int[] subarray, int element) {
        int count = 0;

        for (int currElement : subarray) {
            if (currElement == element) {
                count++;
            }
        }
        return count;

    }
}
