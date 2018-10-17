package dataStructure.array.matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 17/10/18
 * @package dataStructure.array.matrix
 */
public class HourglassSumTest {

    @Test
    public void testHourglassSum() {
        Assert.assertEquals(19, HourglassSum.hourglassSum(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        }));

    }
}
