package problemSolving.leetcode.google;

import java.util.HashSet;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHN APLSIIG YIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    private String s;
    private int rows;
    public String convert(String s, int numRows) {
        this.s = s;
        this.rows = numRows;

        String output = "";
        HashSet<Integer> zigZagIndices = new HashSet<>();

        //initialize


        return output;
    }

    private void initialize(HashSet<Integer> indexes) {

    }
}
