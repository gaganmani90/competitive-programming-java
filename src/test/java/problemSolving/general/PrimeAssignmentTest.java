package problemSolving.general;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 21/12/18
 * @package problemSolving.general
 */
public class PrimeAssignmentTest {

    @Test
    public void testIsPrime(){
        Assert.assertEquals(true, PrimeAssignment.isPrime(7));
        Assert.assertEquals(false, PrimeAssignment.isPrime(10));
    }

    @Test
    public void testPrintPrimeNumbers(){
        PrimeAssignment.printPrimeNumbers(10); //2,3,5,7
        PrimeAssignment.printPrimeNumbers(5); //2,3,5
    }
}
