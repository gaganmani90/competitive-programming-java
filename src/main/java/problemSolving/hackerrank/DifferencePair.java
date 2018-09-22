package problemSolving.hackerrank;

import java.util.HashMap;

/**
 * Given  integers, count the number of pairs of integers whose difference is .
 * <p>
 * Input Format
 * <p>
 * The first line contains  and .
 * The second line contains  numbers of the set. All the  numbers are unique.
 * <p>
 * Constraints
 * <p>
 * Each integer will be greater than  and at least  smaller than .
 * Output Format
 * <p>
 * An integer that tells the number of pairs of integers whose difference is .
 * <p>
 * Sample Input
 * <p>
 * 5 2
 * 1 5 3 4 2
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * There are 3 pairs of integers in the set with a difference of 2.
 *
 * @author gagamani
 */
public class DifferencePair {

    public static int getDiffPairs(int[] arr, int diff) {
        int count = 0;
        HashMap<Integer, Integer> intcount = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (intcount.containsKey(arr[i])) {
                intcount.put(arr[i], (intcount.get(arr[i]) + 1));
            } else {
                intcount.put(arr[i], 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (intcount.containsKey(arr[i] + diff))
                count += intcount.get(arr[i] + diff);

            if (diff + arr[i] == arr[i]) {
                count--;
            }
        }


        return count;
    }

}
