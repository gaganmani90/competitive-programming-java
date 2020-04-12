package problemSolving.codechef;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CovidPandemicLongQueueTest {

    @Test
    public void isSocialDistancingFollowed() {
        Assert.assertEquals("YES", CovidPandemicLongQueue.isSocialDistancingFollowed(new int[]{1 ,0 ,0 ,0, 0, 0, 1}));
        Assert.assertEquals("NO", CovidPandemicLongQueue.isSocialDistancingFollowed(new int[]{1 ,0 ,1}));
        Assert.assertEquals("NO", CovidPandemicLongQueue.isSocialDistancingFollowed(new int[]{0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1}));
    }

}