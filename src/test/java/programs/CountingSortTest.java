package programs;

import org.junit.Assert;
import org.junit.Test;

public class CountingSortTest {

    @Test
    public void sort_test(){
        Assert.assertEquals("[1, 2, 3, 3, 4]", CountingSort.sort(new int[]{3,3,4,2,1}));
    }
}
