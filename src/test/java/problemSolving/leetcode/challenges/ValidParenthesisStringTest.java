package problemSolving.leetcode.challenges;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesisStringTest {

    @Test
    public void checkValidString() {
        Assert.assertEquals(true, ValidParenthesisString.checkValidString("(*)"));
    }

    @Test
    public void checkValidString_greedy() {
    }
}