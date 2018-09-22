package programs.array.sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * QuickSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 22, 2018</pre>
 */
public class QuickSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sort(int[] arr)
     */
    @Test
    public void testSort() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: sortUtil(int[] arr, int low, int high)
     */
    @Test
    public void testSortUtil() throws Exception {
        Assert.assertEquals("[1, 2, 3, 4]", Arrays.toString(QuickSort.sort(new int[]{4, 3, 2, 1})));
        Assert.assertEquals("[4]", Arrays.toString(QuickSort.sort(new int[]{4})));
        Assert.assertEquals("[1, 2, 3, 4]", Arrays.toString(QuickSort.sort(new int[]{1,2,3,4})));
    }


} 
