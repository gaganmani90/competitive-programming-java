package problemSolving.leetcode.challenges;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringShiftsTest {

    @Test
    public void stringShift() {
        Assert.assertEquals("cab",
                StringShifts.stringShift("abc",
                        new int[][]
                        {
                                {0,1},
                                {1,2}
                        }));

        Assert.assertEquals("efgabcd",
                StringShifts.stringShift("abcdefg",
                        new int[][]
                                {
                                        {1,1},
                                        {1,1},
                                        {0,2},
                                        {1,3}
                                }));
    }
}