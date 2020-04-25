package problemSolving.leetcode.contests;

import org.junit.Assert;
import org.junit.Test;

public class ReformatTheStringTest {
    @Test
    public void reformat() {
        Assert.assertEquals("", ReformatTheString.reformat("a0b1c2ccc"));
        Assert.assertEquals("a0b1c2", ReformatTheString.reformat("a0b1c2"));
        Assert.assertEquals("", ReformatTheString.reformat("leetcode"));
        Assert.assertEquals("c2o0v1i9d", ReformatTheString.reformat("covid2019"));
        Assert.assertEquals("1a2b3", ReformatTheString.reformat("ab123"));
    }
}