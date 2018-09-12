package programs.bitwise;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/11/18
 */
public class FlipBitsTest {

    @Test
    public void test_flippedBits(){
        Assert.assertEquals(4, FlipBits.flippedBits(10,20));//00001010, 00010100
        Assert.assertEquals(3, FlipBits.flippedBits(7,10));//00000111, 00001010
    }
}
