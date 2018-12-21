package problemSolving.general;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 21/12/18
 * @package problemSolving.general
 */
public class DivisorSumAssignmentTest {

    @Test
    public void testIsDivisor(){
        Assert.assertEquals(true, DivisorSumAssignment.isDivisor(10,5));
        Assert.assertEquals(false, DivisorSumAssignment.isDivisor(7,3));
    }

    @Test
    public void testDivisorSum(){
        Assert.assertEquals(28, DivisorSumAssignment.divisorSum(28));
        Assert.assertEquals(7, DivisorSumAssignment.divisorSum(8));
        Assert.assertEquals(16, DivisorSumAssignment.divisorSum(12));
    }
}
