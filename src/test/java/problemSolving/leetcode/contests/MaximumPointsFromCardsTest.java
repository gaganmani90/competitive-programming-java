package problemSolving.leetcode.contests;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumPointsFromCardsTest {

    @Test
    public void maxScore() {
        Assert.assertEquals(12, MaximumPointsFromCards.maxScore(new int[]{1,2,3,4,5,6,1}, 3));
        Assert.assertEquals(4, MaximumPointsFromCards.maxScore(new int[]{2,2,2}, 2));
        Assert.assertEquals(55, MaximumPointsFromCards.maxScore(new int[]{9,7,7,9,7,7,9}, 7));
        Assert.assertEquals(1, MaximumPointsFromCards.maxScore(new int[]{1,1000,1}, 1));
        Assert.assertEquals(202, MaximumPointsFromCards.maxScore(new int[]{1,79,80,1,1,1,200,1}, 3));
    }

    @Test
    public void maxScoreOptimized() {
        Assert.assertEquals(12, MaximumPointsFromCards.maxScoreOptimized(new int[]{1,2,3,4,5,6,1}, 3));
       // Assert.assertEquals(4, MaximumPointsFromCards.maxScoreOptimized(new int[]{2,2,2}, 2));
        //Assert.assertEquals(55, MaximumPointsFromCards.maxScoreOptimized(new int[]{9,7,7,9,7,7,9}, 7));
        Assert.assertEquals(1, MaximumPointsFromCards.maxScoreOptimized(new int[]{1,1000,1}, 1));
        Assert.assertEquals(202, MaximumPointsFromCards.maxScoreOptimized(new int[]{1,79,80,1,1,1,200,1}, 3));
    }
}