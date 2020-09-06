package problemSolving.leetcode.contests.sep;

import org.junit.Assert;

public class ReplaceAll {
    public static final char QUESTION_MARK = '?';
    public static final int MAX_CHAR = 122;

    public static String modifyString(String s) {
        StringBuilder out = new StringBuilder();

        if(s.length() == 1 && s.charAt(0) == QUESTION_MARK) {
            return "a";
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != QUESTION_MARK) {
                out.append(c);
                continue;
            }
            replaceQuestionMark(i-1, i+1, out, s);
        }
        return out.toString();
    }

    /**
     * Updates string builder by replacing question mark with appropriate character
     * @param prev
     * @param next
     * @param sb
     * @param s
     */
    private static void replaceQuestionMark(int prev, int next, StringBuilder sb, String s) {
        if (prev >= 0 && next < s.length()) {
            char nextChar = s.charAt(next); //this can be question mark as well
            char nextValidChar = getNextValidChar(sb.charAt(prev), nextChar);
            sb.append(nextValidChar);
        } else {
            if (prev < 0) {
                sb.append(getNextValidChar('a', s.charAt(next)));
            } else if(next >= s.length()) {
                sb.append(getNextValidChar(sb.charAt(prev), 'z'));
            }
        }
    }

    /**
     * Given previous and next character, returns the valid character
     * Example - (a,b) === should return 'c'
     * @param prev
     * @param next
     * @return
     */
    private static char getNextValidChar(char prev, char next) {
        int offset = 1;
        if(next == QUESTION_MARK) {
            return normalizedChar(prev, offset);
        }
        if (normalizedChar(prev, offset) == next) {
            offset = 2;
        }
        return normalizedChar(prev, offset);
    }

    /**
     * To handle edge cases, where c='z' and offset is 1 then it should return 'a'
     * @param c
     * @param offset
     * @return
     */
    private static char normalizedChar(char c, int offset) {
        if (c + offset > MAX_CHAR) {
            return (char) (MAX_CHAR - 26 + offset);
        } else {
            return (char) (c + offset);
        }
    }

    public static void main(String[] args) {
        Assert.assertEquals("bcd", modifyString("???"));
        Assert.assertEquals("bzs", modifyString("?zs"));
        Assert.assertEquals("bubvxw", modifyString("?ubv?w"));
        Assert.assertEquals("zba", modifyString("z?a"));
        Assert.assertEquals("aba", modifyString("a?a"));
        Assert.assertEquals("ba", modifyString("?a"));
        Assert.assertEquals("a", modifyString("a"));
        Assert.assertEquals("a", modifyString("?"));
    }
}
