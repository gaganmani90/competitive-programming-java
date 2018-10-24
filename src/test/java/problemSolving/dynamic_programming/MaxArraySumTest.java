package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 24/10/18
 * @package problemSolving.dynamic_programming
 */
public class MaxArraySumTest {

    @Test
    public void testMaxArraySum() {
        Assert.assertEquals(15, MaxArraySum.maxArraySum(new int[]{3, 5, -7, 8, 10}));
        Assert.assertEquals(11, MaxArraySum.maxArraySum(new int[]{2, 1, 5, 8, 4}));
        Assert.assertEquals(13, MaxArraySum.maxArraySum(new int[]{3, 7, 4, 6, 5}));
        Assert.assertEquals(1, MaxArraySum.maxArraySum(new int[]{0, 0, 0, 0, 1}));
        Assert.assertEquals(0, MaxArraySum.maxArraySum(new int[]{0, -1, -1,-1, -1}));
    }
}
