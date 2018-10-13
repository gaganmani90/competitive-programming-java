package problemSolving.dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/12/18
 */
public class LongestCommonSubstringTest {

    @Test
    public void test_longestCommonString(){
        Assert.assertEquals("ab",LongestCommonSubstring.lengthOflongestComSubstring("abcd","ab"));
        Assert.assertEquals("grace",LongestCommonSubstring.lengthOflongestComSubstring("grace","graceful"));
        Assert.assertEquals("abcd",LongestCommonSubstring.lengthOflongestComSubstring("abcdxyz","xyzabcd"));
        Assert.assertEquals("abcdez",LongestCommonSubstring.lengthOflongestComSubstring("zxabcdezy","yzabcdezx"));
        Assert.assertEquals("Geeks",LongestCommonSubstring.lengthOflongestComSubstring("GeeksforGeeks","GeeksQuiz"));
    }
}
