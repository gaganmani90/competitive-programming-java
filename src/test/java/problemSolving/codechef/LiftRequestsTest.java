package problemSolving.codechef;

import org.junit.Assert;
import org.junit.Test;

public class LiftRequestsTest {

    @Test
    public void totalFloorsTravelled() {
        Assert.assertEquals(10, LiftRequests.totalFloorsTravelled(6, new int[][]{
                {5,0},
        }));
        Assert.assertEquals(6, LiftRequests.totalFloorsTravelled(3, new int[][]{
                {1,2},
                {0,1},
                {1,0}
        }));
    }
}