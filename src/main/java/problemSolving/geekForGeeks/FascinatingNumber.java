package problemSolving.geekForGeeks;

import java.util.LinkedList;

/**
 * <pre>
 *     Given a number N, the task is to check whether it is fascinating or not.
 * Fascinating Number: When a number( 3 digits or more ) is multiplied by 2 and 3,
 * and when both these products are concatenated with the original number,
 * then it results in all digits from 1 to 9 present exactly once. There could be any number of zeros and are ignored.
 *
 * Examples:
 *
 * Input: 192
 * Output: Yes
 * After multiplication with 2 and 3, and concatenating with original number,
 * resultant number is 192384576 which contains all digits from 1 to 9.
 *
 * Input: 853
 * Output: No
 * After multiplication with 2 and 3, and concatenating with original number,
 * the resultant number is 85317062559. In this, number 4 is missing and the number 5 has appeared multiple times.
 * </pre>
 *
 * @author gagamani
 * @date 9/24/18
 */
public class FascinatingNumber {

    static boolean isFascinatingNumber(int num) {

        if(num == 0){
            return false;
        }
        long concatinatedNumber = concatinate(num, num * 2, num * 3);
        return isOneToNine(concatinatedNumber);

    }

    private static boolean isOneToNine(long number) {
        LinkedList<Integer> digits = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        while (number != 0) {
            long rem = number % 10;
            number = number / 10;
            if (digits.size() > 0) {
                digits.remove(new Integer((int) rem)); //tricky
            }
        }

        if (digits.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static long concatinate(int... numbers) {
        StringBuilder number = new StringBuilder();
        for (int currNumber : numbers) {
            number.append(currNumber);
        }

        if (number.length() == 0) {
            return -1;
        }
        return Long.parseLong(number.toString());
    }
}
