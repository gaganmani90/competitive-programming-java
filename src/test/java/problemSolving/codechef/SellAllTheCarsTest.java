package problemSolving.codechef;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellAllTheCarsTest {

    @Test
    public void getProfit() {
        Assert.assertEquals(7, SellAllTheCars.getProfit(new long[]{3,5,2}));
        Assert.assertEquals(15, SellAllTheCars.getProfit(new long[]{6,6,6}));
        Assert.assertEquals(1, SellAllTheCars.getProfit(new long[]{0,1,0}));
        /**
         * 1: 2,7,13,4 -> 13
         * 2: 1,6,-1,3 -> 6
         * 3: 0,-1,-1,2 -> 2
         * 4: 0,-1,-1,-1 -> 0
         */
        Assert.assertEquals(21, SellAllTheCars.getProfit(new long[]{2,7,13,4})); //13+6+2+0
    }
}