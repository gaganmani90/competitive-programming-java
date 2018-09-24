package problemSolving.geekForGeeks;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/24/18
 */
public class FascinatingNumberTest {

    @Test
    public void testIsFascinatingNumber(){
        Assert.assertEquals(true, FascinatingNumber.isFascinatingNumber(192));
        Assert.assertEquals(false, FascinatingNumber.isFascinatingNumber(853));
        Assert.assertEquals(false, FascinatingNumber.isFascinatingNumber(0));
        Assert.assertEquals(false, FascinatingNumber.isFascinatingNumber(2));
    }
}
