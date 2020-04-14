package problemSolving.leetcode.challenges;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */
public class StringShifts {
    public static String stringShift(String s, int[][] shift) {
        int startIndex = 0;

        for(int row = 0; row < shift.length; row++) {
            startIndex = makeShift(startIndex, s.length(), shift[row]);
        }
        return getShiftedWord(s, startIndex);
    }

    /**
     *
     * @param length
     * @param shift
     * @return shifted start index
     */
    private static int makeShift(int startIndex, int length, int[] shift) {
        int newStartIndex = 0;
        if(shift[0] == 1) { //right shift
            int tempIndex = (startIndex - shift[1]);
            if((tempIndex < 0)) {
                newStartIndex = length - Math.abs(tempIndex);
            } else {
                newStartIndex = tempIndex;
            }
        } else { //left shift
            newStartIndex = (startIndex + shift[1]) % length;
        }
        return newStartIndex;
    }

    /**
     * example: word: abc, shifted: cab, startIndex = 1
     * @param word
     * @param startIndex
     * @return
     */
    private static String getShiftedWord(String word, int startIndex) {
        StringBuilder shiftedWord = new StringBuilder();
        for(int i = startIndex; i < startIndex + word.length(); i++) {
            shiftedWord.append(word.charAt(i % word.length()));
        }
        return shiftedWord.toString();
    }
}
