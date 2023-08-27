package algorithms.msft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceGainTest {

    @Test
    void maxProfit() {
        Assertions.assertEquals(PriceGain.maxProfit(new int[]{4, 1, 2, 3}), 6);
        Assertions.assertEquals(PriceGain.maxProfit(new int[]{1, 2, 3, 3, 2, 1, 5}), 7);
        Assertions.assertEquals(PriceGain.maxProfit(new int[]{1000000000, 1, 2, 2, 1000000000, 1, 1000000000}), 999999998);
    }
}