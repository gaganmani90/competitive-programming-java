package problemSolving.general.bitwise;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberRangeTest {

    @Test
    public void rangeBitwiseAnd() {
        Assert.assertEquals(4, NumberRange.rangeBitwiseAnd(5,7));
        Assert.assertEquals(0, NumberRange.rangeBitwiseAnd(0,1));
        Assert.assertEquals(64, NumberRange.rangeBitwiseAnd(65,119));
        Assert.assertEquals(0, NumberRange.rangeBitwiseAnd(51,119));
    }

    @Test
    public void rangeBitwiseAndOptimized() {
        Assert.assertEquals(4, NumberRange.rangeBitwiseAndOptimized(5,7));
        Assert.assertEquals(0, NumberRange.rangeBitwiseAndOptimized(0,1));
        Assert.assertEquals(64, NumberRange.rangeBitwiseAndOptimized(65,119));
        Assert.assertEquals(0, NumberRange.rangeBitwiseAndOptimized(51,119));
    }
}