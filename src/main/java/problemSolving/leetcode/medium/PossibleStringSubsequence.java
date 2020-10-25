package problemSolving.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String,
 * that is generated by deleting some character of a given string without changing its order.
 */
@Slf4j
public class PossibleStringSubsequence {

    private static void findsubsequences(String s, String ans, List<String> subsequences) {
        if (s.length() == 0) {
            subsequences.add(ans);
            return;
        }

        // We add adding 1st character in string
        findsubsequences(s.substring(1), ans +
                s.charAt(0), subsequences);

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s.substring(1), ans, subsequences);
    }

    public static List<String> getSubsequences(String input) {
        List<String> subsequences = new ArrayList<>();
        findsubsequences(input, "", subsequences);
        return subsequences;
    }

    public static void main(String[] args) {
        log.info(getSubsequences("abc").toString());
    }
}
