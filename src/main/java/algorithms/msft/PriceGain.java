package algorithms.msft;

import java.util.ArrayList;
import java.util.List;

public class PriceGain {
        public static int maxProfit(int[] prices) {

            List<Integer> priceGain = new ArrayList<>();
            priceGain.add(prices[0]);

            for(int idx = 0 ; idx < prices.length-1; idx++){

                if( prices[idx] < prices[idx+1] ){
                    priceGain.add( prices[idx+1]- prices[idx]);
                }

            }
            return priceGain.stream().mapToInt(n->n).sum();

    }
}
