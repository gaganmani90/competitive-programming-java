package problemSolving.codechef;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrangeNumberTest {

    @Test
    public void strangeNumber() {
        Assert.assertEquals(0, StrangeNumber.strangeNumber(1,1));
        Assert.assertEquals(2, StrangeNumber.strangeNumber(2,1));
        Assert.assertEquals(6, StrangeNumber.strangeNumber(4,2));
        Assert.assertEquals(0, StrangeNumber.strangeNumber(10,6));
        Assert.assertEquals(30, StrangeNumber.strangeNumber(8,3));
        Assert.assertEquals(36, StrangeNumber.strangeNumber(9,4));
    }

    @Test
    public void primeFactors() {
        Assert.assertEquals("{2=2, 3=2}",StrangeNumber.primeFactors(36).toString());
        Assert.assertEquals("{2=1, 3=1, 5=1}",StrangeNumber.primeFactors(30).toString());
        Assert.assertEquals("{2=1, 5=1}",StrangeNumber.primeFactors(10).toString());
        Assert.assertEquals("{2=2, 5=2}",StrangeNumber.primeFactors(100).toString());
    }
}