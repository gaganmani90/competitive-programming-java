package problemSolving.leetcode.challenges;

import org.junit.Assert;
import org.junit.Test;

public class ContiguousArrayOneAndZeroTest {

    @Test
    public void findMaxLength() {
        Assert.assertEquals(6, ContiguousArrayOneAndZero.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
        Assert.assertEquals(2, ContiguousArrayOneAndZero.findMaxLength(new int[]{0,1}));
        Assert.assertEquals(2, ContiguousArrayOneAndZero.findMaxLength(new int[]{0,1,0}));
        Assert.assertEquals(4, ContiguousArrayOneAndZero.findMaxLength(new int[]{0,1,0,1}));
        Assert.assertEquals(2, ContiguousArrayOneAndZero.findMaxLength(new int[]{0,0,0,1}));
        Assert.assertEquals(0, ContiguousArrayOneAndZero.findMaxLength(new int[]{0,0,0,0}));
    }

    @Test
    public void findMaxLength_optimized() {
        Assert.assertEquals(6, ContiguousArrayOneAndZero.findMaxLength_optimized(new int[]{0,0,1,0,0,0,1,1}));
        Assert.assertEquals(2, ContiguousArrayOneAndZero.findMaxLength_optimized(new int[]{0,1}));
        Assert.assertEquals(2, ContiguousArrayOneAndZero.findMaxLength_optimized(new int[]{0,1,0}));
        Assert.assertEquals(4, ContiguousArrayOneAndZero.findMaxLength_optimized(new int[]{0,1,0,1}));
        Assert.assertEquals(2, ContiguousArrayOneAndZero.findMaxLength_optimized(new int[]{0,0,0,1}));
        Assert.assertEquals(0, ContiguousArrayOneAndZero.findMaxLength_optimized(new int[]{0,0,0,0}));
    }
}