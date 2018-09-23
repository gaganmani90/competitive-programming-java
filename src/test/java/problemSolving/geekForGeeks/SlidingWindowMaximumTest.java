package problemSolving.geekForGeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/23/18
 */
public class SlidingWindowMaximumTest {

    @Test
    public void testSlidingMaxArray() {
        Assert.assertEquals("[3, 3, 4, 5, 5, 5, 6]", SlidingWindowMaximum.slidingMaxArray(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
        Assert.assertEquals("[10, 10, 10, 15, 15, 90, 90]", SlidingWindowMaximum.slidingMaxArray(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4));
        Assert.assertEquals("window size is same as array","[1, 2, 3]", SlidingWindowMaximum.slidingMaxArray(new int[]{1, 2, 3}, 3));
        Assert.assertEquals("window size is greater than array","[1, 2, 3]", SlidingWindowMaximum.slidingMaxArray(new int[]{1, 2, 3}, 30));
    }
}
