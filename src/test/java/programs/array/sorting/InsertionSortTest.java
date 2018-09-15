package programs.array.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author gagamani
 * @date 9/15/18
 */
public class InsertionSortTest {

    @Test
    public void test_sort(){
        Assert.assertEquals("[1, 2, 3, 4]", Arrays.toString(InsertionSort.sort(new int[]{3,4,2,1})));
    }
}
