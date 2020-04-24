package problemSolving;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestNonRepeatingSubstringTest {

    @Test
    public void longestSubstring() {
        Assert.assertEquals(8, LongestNonRepeatingSubstring.longestSubstring("abcabcbjdbfsnxbvcjxbb"));
        Assert.assertEquals(3, LongestNonRepeatingSubstring.longestSubstring("nndfddf"));
        Assert.assertEquals(5, LongestNonRepeatingSubstring.longestSubstring("abcde"));
        Assert.assertEquals(1, LongestNonRepeatingSubstring.longestSubstring("aaaa"));
        Assert.assertEquals(0, LongestNonRepeatingSubstring.longestSubstring(""));
        Assert.assertEquals(4, LongestNonRepeatingSubstring.longestSubstring("ninjaja"));
    }
}