package problemSolving.bitwise;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/10/18
 */
public class CountSetBitsTest {

    @Test
    public void test_bits(){
        Assert.assertEquals(2, CountSetBits.bits(3)); //0011
        Assert.assertEquals(1, CountSetBits.bits(4)); //0100
        Assert.assertEquals(1, CountSetBits.bits(64)); //0100 0000
        Assert.assertEquals(3, CountSetBits.bits(67)); //0100 0011
    }
}
