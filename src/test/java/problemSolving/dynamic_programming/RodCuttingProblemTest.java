package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaganmani
 * @date 13/10/18
 * @package problemSolving.dynamic_programming
 */
public class RodCuttingProblemTest {

    @Test
    public void testMaximumRevenue_recursive() {
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem(new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30});
        Assert.assertEquals("two rods of size 2 would have max revenue",10, rodCuttingProblem.maximumRevenue_recursive(4));
        Assert.assertEquals("rod can not be broken down to increase revenue",5, rodCuttingProblem.maximumRevenue_recursive(2));
        Assert.assertEquals("rod can not be broken down to increase revenue",1, rodCuttingProblem.maximumRevenue_recursive(1));
        Assert.assertEquals("p2+p3=13",13, rodCuttingProblem.maximumRevenue_recursive(5));
    }

    @Test
    public void testMaximumRevenue() {
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem(new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30});
        Assert.assertEquals("two rods of size 2 would have max revenue",10, rodCuttingProblem.maximumRevenue_bottomUp(4));
        Assert.assertEquals("rod can not be broken down to increase revenue",5, rodCuttingProblem.maximumRevenue_bottomUp(2));
        Assert.assertEquals("rod can not be broken down to increase revenue",1, rodCuttingProblem.maximumRevenue_bottomUp(1));
        Assert.assertEquals("p2+p3=13",13, rodCuttingProblem.maximumRevenue_bottomUp(5));
        Assert.assertEquals("p3=8",8, rodCuttingProblem.maximumRevenue_bottomUp(3));
    }

    @Test
    public void testMaximumRevenueTopdown() {
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem(new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30});
        Assert.assertEquals("two rods of size 2 would have max revenue",10, rodCuttingProblem.maximumRevenue_topDown(4));
        Assert.assertEquals("rod can not be broken down to increase revenue",5, rodCuttingProblem.maximumRevenue_topDown(2));
        Assert.assertEquals("rod can not be broken down to increase revenue",1, rodCuttingProblem.maximumRevenue_topDown(1));
        Assert.assertEquals("p2+p3=13",13, rodCuttingProblem.maximumRevenue_topDown(5));
        Assert.assertEquals("p3=8",8, rodCuttingProblem.maximumRevenue_topDown(3));
    }
}
