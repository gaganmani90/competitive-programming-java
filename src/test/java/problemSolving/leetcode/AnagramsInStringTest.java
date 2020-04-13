package problemSolving.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramsInStringTest {

    @Test
    public void findAnagrams() {
        AnagramsInString anagram = new AnagramsInString();
        Assert.assertEquals("[0, 6]", anagram.findAnagrams("cbaebabacd", "abc").toString());
        Assert.assertEquals("[0, 1, 2]", anagram.findAnagrams("abab", "ab").toString());
        Assert.assertEquals("[1, 2, 3, 5]", anagram.findAnagrams("abacbabc", "abc").toString());
    }
}