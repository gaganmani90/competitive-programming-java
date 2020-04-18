package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {

    @Test
    public void minPathSum() {
        Assert.assertEquals(5, MinimumPathSum.minPathSum(new int[][]
                {
                        {1,3,1},
                }));
        Assert.assertEquals(9, MinimumPathSum.minPathSum(new int[][]
                {
                        {1},
                        {3},
                        {5}
                }));
        Assert.assertEquals(7, MinimumPathSum.minPathSum(new int[][]
                {
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                 }));
    }
}