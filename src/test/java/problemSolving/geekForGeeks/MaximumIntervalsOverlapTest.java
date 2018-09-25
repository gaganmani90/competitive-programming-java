package problemSolving.geekForGeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/25/18
 */
public class MaximumIntervalsOverlapTest {

    @Test
    public void testMaximumOverlap() {
        Assert.assertEquals(5, MaximumIntervalsOverlap.maximumOverlap(new int[]{1, 2, 9, 5, 5}, new int[]{4, 5, 12, 9, 12}));
        Assert.assertEquals(-1, MaximumIntervalsOverlap.maximumOverlap(new int[]{1, 2, 9, 5, 5,8}, new int[]{4, 5, 12, 9, 12}));
    }
}
