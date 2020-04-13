package problemSolving.general;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfFactorsTest {

    @Test
    public void factors() {
        Assert.assertEquals(5, NumberOfFactors.factors(120));
        Assert.assertEquals(4, NumberOfFactors.factors(315));
    }
}