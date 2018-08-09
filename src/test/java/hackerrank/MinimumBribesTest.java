package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class MinimumBribesTest {

    @Test
    public void minimamBribe_test(){
        Assert.assertEquals(3, MinimumBribes.minimumBribes(new int[]{2,1,5,3,4}));
        Assert.assertEquals(0, MinimumBribes.minimumBribes(new int[]{2,5,1,3,4}));
    }
}
