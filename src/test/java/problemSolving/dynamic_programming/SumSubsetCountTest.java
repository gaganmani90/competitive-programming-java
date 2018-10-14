package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class SumSubsetCountTest {

    @Test
    public void testSubset() {
        Assert.assertEquals(2, SumSubsetCount.subsets(new int[]{2, 4, 6, 10}, 16));
    }
}
