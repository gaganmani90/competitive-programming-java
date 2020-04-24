package problemSolving.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VowelSubstringTest {

    @Test
    public void findSubstring() {
        //Assert.assertEquals("erqii", VowelSubstring.findSubstring("caberqiitefg",5));
        //Assert.assertEquals("Not found!", VowelSubstring.findSubstring("bbc",3));
        Assert.assertEquals("erdii", VowelSubstring.findSubstring("azerdii",5));
    }
}