package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/12/18
 */
public class LongestCommonSubsequenceTest {

    @Test
    public void test_longestCommonString(){
        Assert.assertEquals(4,LongestCommonSubsequence.lengthOflongestComSubsequence("abcdaf","acbcf"));
        Assert.assertEquals(3,LongestCommonSubsequence.lengthOflongestComSubsequence("ABCDGH","AEDFHR"));
        Assert.assertEquals(4,LongestCommonSubsequence.lengthOflongestComSubsequence("AGGTAB","GXTXAYB"));
    }
}
