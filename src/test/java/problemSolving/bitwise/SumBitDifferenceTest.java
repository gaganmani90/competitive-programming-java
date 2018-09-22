package problemSolving.bitwise;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/10/18
 */
public class SumBitDifferenceTest {

    @Test
    public void test_bitDifference(){
        Assert.assertEquals(3, SumBitDifference.bitDifference(3,4));//0011,0100
        Assert.assertEquals(0, SumBitDifference.bitDifference(11,11));//1011,1011
        Assert.assertEquals(4, SumBitDifference.bitDifference(15,0));//1111,0000

    }

    @Test
    public void test_sumOfAllPairsBitDiff(){
        Assert.assertEquals(4, SumBitDifference.sumOfAllPairsBitDiff(new int[]{1,2}));
        Assert.assertEquals(8, SumBitDifference.sumOfAllPairsBitDiff(new int[]{1,3,5}));
    }
}
