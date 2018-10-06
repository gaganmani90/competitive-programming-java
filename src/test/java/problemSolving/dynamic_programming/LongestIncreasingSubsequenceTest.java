package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence(){
        LongestIncreasingSubsequence increasingSubsequence = new LongestIncreasingSubsequence(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80});
        Assert.assertEquals(6, increasingSubsequence.longestCommonSubsequence());

        increasingSubsequence = new LongestIncreasingSubsequence(new int[]{1});
        Assert.assertEquals(1, increasingSubsequence.longestCommonSubsequence());

        Assert.assertEquals(2, new LongestIncreasingSubsequence(new int[]{1,2}).longestCommonSubsequence());
        Assert.assertEquals(1, new LongestIncreasingSubsequence(new int[]{2,1}).longestCommonSubsequence());
        Assert.assertEquals(1, new LongestIncreasingSubsequence(new int[]{2,2}).longestCommonSubsequence());
        Assert.assertEquals(3, new LongestIncreasingSubsequence(new int[]{10,22,8,9,11,2}).longestCommonSubsequence());
    }
}
