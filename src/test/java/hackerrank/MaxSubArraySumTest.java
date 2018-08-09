package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArraySumTest {

    @Test
    public void maxSubArraySum_adjacent_test(){
        Assert.assertEquals(20, MaxSubArraySum.maxSubArraySum_adjacent(new int[]{2,1,5,8,4}));
        Assert.assertEquals(18, MaxSubArraySum.maxSubArraySum_adjacent(new int[]{2,-1,5,8,4}));
        Assert.assertEquals(17, MaxSubArraySum.maxSubArraySum_adjacent(new int[]{-2,-1,5,8,4}));
        Assert.assertEquals(17, MaxSubArraySum.maxSubArraySum_adjacent(new int[]{1,-6,5,8,4}));
        Assert.assertEquals(12, MaxSubArraySum.maxSubArraySum_adjacent(new int[]{1,6,-11,8,4}));
    }
}
