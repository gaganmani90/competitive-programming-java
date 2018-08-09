package programs.array;

import org.junit.Assert;
import org.junit.Test;

public class SubarrayZeroSumTest {

    @Test
    public void isZeroSumSubarray_test(){
        Assert.assertTrue(SubarrayZeroSum.isZeroSumSubarray(new int[]{1,-2,1}));
        Assert.assertTrue(SubarrayZeroSum.isZeroSumSubarray(new int[]{4, 2, -3, 1, 6}));
        Assert.assertTrue(SubarrayZeroSum.isZeroSumSubarray(new int[]{4, 2, 0, 1, 6}));
        Assert.assertFalse(SubarrayZeroSum.isZeroSumSubarray(new int[]{-3, 2, 3, 1, 6}));
    }

    @Test
    public void isZeroSumSubarray_optimized_test(){
        Assert.assertTrue(SubarrayZeroSum.isZeroSumSubarray_optimized(new int[]{1,-2,1}));
        Assert.assertTrue(SubarrayZeroSum.isZeroSumSubarray_optimized(new int[]{4, 2, -3, 1, 6}));
        Assert.assertTrue(SubarrayZeroSum.isZeroSumSubarray_optimized(new int[]{4, 2, 0, 1, 6}));
        Assert.assertFalse(SubarrayZeroSum.isZeroSumSubarray_optimized(new int[]{-3, 2, 3, 1, 6}));
    }
}
