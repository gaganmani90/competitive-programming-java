package problemSolving;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AngleBracketsTest {

    @Test
    public void completeBrackets() {
        AngleBrackets angleBrackets = new AngleBrackets();
        Assert.assertEquals("", angleBrackets.completeBrackets(""));
        Assert.assertEquals("<><<><>>", angleBrackets.completeBrackets("><<><"));
        Assert.assertEquals("<<>>", angleBrackets.completeBrackets("<<"));
        Assert.assertEquals("<<>>", angleBrackets.completeBrackets(">>"));
        Assert.assertEquals("<<<<<>>>>><<<>>>", angleBrackets.completeBrackets("<>>>>><<<>>"));
    }
}