package algorithms.msft;

public class SwitchingArray {
    public static int switchingArray(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int even = arr[0], odd = arr[1];
        int start = 0, max_len = 0;
        for (int indx = 2; indx < arr.length; ++indx) {
            System.out.println((indx + " % 2 != 0 " + (indx % 2 != 0) + " or " + (arr[indx] + " is even ") + (arr[indx] == even) + " and" + (" indx % 2 != 1 ") + (indx % 2 != 1) + ", " + (arr[indx] + " == odd ") + (arr[indx] == odd)));
            if ((indx % 2 != 0 || arr[indx] == even) && (indx % 2 != 1 || arr[indx] == odd)) {
                /*  if condition is true then skip this iteration   */
                System.out.println("hence skip this iteration");
                continue;
            }
            max_len = Math.max(max_len, indx - start);
            start = indx - 1;
            if (indx % 2 == 0) {
                even = arr[indx];
                odd = arr[indx - 1];
            } else {
                even = arr[indx - 1];
                odd = arr[indx];
            }
        }
        return Math.max(max_len, arr.length - start);
    }
}