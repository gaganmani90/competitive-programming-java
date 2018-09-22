package problemSolving.hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class DifferencePairTest {

    @Test
    public void getDiffPairs_test(){
        Assert.assertEquals(3, DifferencePair.getDiffPairs(new int[]{1,5,3,4,2}, 2));
    }
}
