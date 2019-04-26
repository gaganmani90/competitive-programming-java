package problemSolving.hackerrank;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 26/04/19
 * @package problemSolving.hackerrank
 */
public class SeparateTheNumbersTest {

    @Test
    public void separateNumbers2_test(){
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("1011"), "10");
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("1012"), "NO");
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("8910"), "8");
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("8910"), "8");
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("10001001"), "1000");
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("5678"), "5");
        Assert.assertEquals(SeparateTheNumbers.separateNumbers2("9989991000"), "998");
    }
}
