package programs;


import org.junit.Assert;
import org.junit.Test;

public class RecycledPairsTest {

    @Test
    public void recycledPairs_test(){
        Assert.assertTrue(RecycledPairs.isRecycledPairs(1234,4123));
        Assert.assertFalse(RecycledPairs.isRecycledPairs(1234,4132));
        Assert.assertFalse(RecycledPairs.isRecycledPairs(1,1));
        Assert.assertTrue(RecycledPairs.isRecycledPairs(1212,2121));
        Assert.assertTrue(RecycledPairs.isRecycledPairs(13,31));
        Assert.assertTrue(RecycledPairs.isRecycledPairs(23,32));
    }
}
