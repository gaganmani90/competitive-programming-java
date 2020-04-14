package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Given a value V, if we want to make change for V cents, and
 * we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 * what is the minimum number of coins to make the change?
 * Examples:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 *
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class MinimumCoinChangeTest {

    @Test
    public void minimumCoins() {
        Assert.assertEquals(2, MinimumCoinChange.minimumCoins(new int[]{25,10,5}, 30));
        Assert.assertEquals(2, MinimumCoinChange.minimumCoins(new int[]{9,6,5,1}, 11));
        Assert.assertEquals(1, MinimumCoinChange.minimumCoins(new int[]{2}, 2));
    }
}