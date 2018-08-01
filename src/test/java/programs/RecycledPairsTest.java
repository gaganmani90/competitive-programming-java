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

    @Test
    public void numberOfRecycledPairs_test(){
        Assert.assertEquals(2, RecycledPairs.numberOfRecycledPairs(new int[]{32, 42, 13, 23, 9, 5, 31}));
        Assert.assertEquals(1, RecycledPairs.numberOfRecycledPairs(new int[]{1212, 2121}));
        Assert.assertEquals(2, RecycledPairs.numberOfRecycledPairs(new int[]{1212, 2121,1212, 2121}));
    }

    @Test
    public void numberOfRecycledPairs_optimized_test(){
        Assert.assertEquals(2, RecycledPairs.numberOfRecycledPairs_optimized(new int[]{32, 42, 13, 23, 9, 5, 31}));
        Assert.assertEquals(1, RecycledPairs.numberOfRecycledPairs_optimized(new int[]{1212, 2121}));
        Assert.assertEquals(2, RecycledPairs.numberOfRecycledPairs_optimized(new int[]{1212, 2121,1212, 2121}));
    }
}
