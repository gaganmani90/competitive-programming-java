package dataStructure.array.matrix;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceTest {

    /**
     * {'0', '*', '0', 's'},
     * * {'*', '0', '*', '*'},
     * * {'0', '*', '*', '*'},
     * * {'d', '*', '*', '*'}
     */
    @Test
    public void testGetShortestDistance1() {
        String[][] route = {
                {"0", "*", "0", "s"},
                {"*", "0", "*", "*"},
                {"0", "*", "*", "*"},
                {"d", "*", "*", "*"}
        };

        ShortestDistance shortestDistance = new ShortestDistance(route);

        Assert.assertEquals(6, shortestDistance.getShortestDistance());
    }

    @Test
    public void testGetShortestDistance2() {
        String[][] route = {
                {"*", "s"},
                {"d", "*"},
        };

        ShortestDistance shortestDistance = new ShortestDistance(route);

        Assert.assertEquals(2, shortestDistance.getShortestDistance());
    }
}
