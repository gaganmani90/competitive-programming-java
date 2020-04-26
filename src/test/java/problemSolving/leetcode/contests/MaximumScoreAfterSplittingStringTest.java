package problemSolving.leetcode.contests;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumScoreAfterSplittingStringTest {

    @Test
    public void test(){
        Assert.assertEquals(5, MaximumScoreAfterSplittingString.maxScore("00111"));
        Assert.assertEquals(5, MaximumScoreAfterSplittingString.maxScore("011101"));
        Assert.assertEquals(3, MaximumScoreAfterSplittingString.maxScore("1111"));

    }


}