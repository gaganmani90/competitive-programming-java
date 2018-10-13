package problemSolving.dynamic_programming;

import java.util.Iterator;
import java.util.Stack;

/**
 * Longest Common Substring count in an Array of Strings
 * <pre>
 * Input : X = "GeeksforGeeks", y = "GeeksQuiz"
 * Output : 5
 * The longest common substring is "Geeks" and is of
 * length 5.
 *
 * Input : X = "abcdxyz", y = "xyzabcd"
 * Output : 4
 * The longest common substring is "abcd" and is of
 * length 4.
 *
 * Input : X = "zxabcdezy", y = "yzabcdezx"
 * Output : 6
 * The longest common substring is "abcdez" and is of
 * length 6.
 * <pre/>
 * @author gagamani
 * @date 9/12/18
 */
public class LongestCommonSubstring {

    static String lengthOflongestComSubstring(String a, String b) {

        int[][] Length = new int[a.length() + 1][b.length() + 1];
        int len = 0;
        StringBuilder builder = new StringBuilder();
        int imax = 0, jmax = 0;

        for (int i = 1; i < Length.length; i++) {
            for (int j = 1; j < Length[0].length; j++) {

                //if characters are same then increase length by 1 from diagonally
                 if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    Length[i][j] = Length[i - 1][j - 1] + 1;
                    if(Length[i][j] > len){
                        len = Length[i][j];
                        imax = i;
                        jmax = j;
                    }

                } else { //if char are not same then longest common substring is 0
                    Length[i][j] = 0;
                }

            }
        }

        /**
         * Create longest sub string
         */
        Stack<Character> out = new Stack<>();
        while(Length[imax][jmax] != 0){
            out.push(a.charAt(imax-1));
            imax--;
            jmax--;
        }

        Iterator<Character> iter = out.iterator();
        while (iter.hasNext()){
            builder.append(out.pop());

        }

        return builder.toString();

    }



}
