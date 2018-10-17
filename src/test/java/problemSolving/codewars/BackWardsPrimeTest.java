package problemSolving.codewars;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 17/10/18
 * @package problemSolving.codewars
 */
public class BackWardsPrimeTest {

    @Test
    public void backWardsPrime13() {
        Assert.assertEquals("13 17 31 37 71 73 79 97", BackWardsPrime.backwardsPrime(1, 100));
    }
    @Test
    public void backWardsPrime21() {
        Assert.assertEquals("9923 9931 9941 9967", BackWardsPrime.backwardsPrime(9900, 10000));
    }
}
