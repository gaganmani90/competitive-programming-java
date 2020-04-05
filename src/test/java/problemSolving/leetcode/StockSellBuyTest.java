package problemSolving.leetcode;

import org.junit.Assert;
import org.junit.Test;


public class StockSellBuyTest {

    @Test
    public void test_maxProfit() {
        Assert.assertEquals(7, StockSellBuy.maxProfit(new int[]{7,1,5,3,6,4}));
        Assert.assertEquals(4, StockSellBuy.maxProfit(new int[]{1,2,3,4,5}));
        Assert.assertEquals(0, StockSellBuy.maxProfit(new int[]{7,6,4,3,1}));
    }

}