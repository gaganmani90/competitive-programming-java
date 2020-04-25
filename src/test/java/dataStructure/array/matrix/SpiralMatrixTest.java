package dataStructure.array.matrix;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class SpiralMatrixTest {

    @Ignore
    @Test
    public void spiralOrder() {

        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 5, 4), new SpiralMatrix(
                new int[][]{
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                }
        ).spiralOrder());
        Assert.assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5), new SpiralMatrix(
                new int[][]{
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                }
        ).spiralOrder());

    }
}