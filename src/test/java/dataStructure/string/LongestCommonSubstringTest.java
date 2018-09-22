package dataStructure.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/12/18
 */
public class LongestCommonSubstringTest {

    @Test
    public void test_longestCommonString(){
        Assert.assertEquals("sad", LongestCommonSubstring.longestCommonString(new String[]{"sadness", "sad", "sadly"}));
        Assert.assertEquals("grace", LongestCommonSubstring.longestCommonString
                (new String[]{"grace", "graceful", "disgraceful", "gracefully"}));
        Assert.assertEquals("", LongestCommonSubstring.longestCommonString(new String[]{"a", "b", "c"}));
        Assert.assertEquals("a", LongestCommonSubstring.longestCommonString(new String[]{"ua", "ba", "ca"}));
    }
}
