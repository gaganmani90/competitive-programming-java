package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class LargestSumContiguousTest {

    @Test
    public void testMaximumContiguousSum() {
        Assert.assertEquals("normal case", 7, LargestSumContiguous.maximumContiguousSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        Assert.assertEquals("all negative numbers", -1, LargestSumContiguous.maximumContiguousSum(new int[]{-4, -2, -3, -1}));
        Assert.assertEquals("null array", -1, LargestSumContiguous.maximumContiguousSum(null));
        Assert.assertEquals("one element in array", 1, LargestSumContiguous.maximumContiguousSum(new int[]{1}));
    }
}
