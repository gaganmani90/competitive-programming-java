package programs.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * BinarySearch Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 21, 2018</pre>
 */
public class BinarySearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: search(int[] arr, int x)
     */
    @Test
    public void testSearch() throws Exception {
        Assert.assertEquals(2, BinarySearch.search(new int[]{1, 2, 3, 4}, 3, BinarySearch.SearchType.RECURSIVE));
        Assert.assertEquals(-1, BinarySearch.search(new int[]{1, 2, 4, 3}, 3,BinarySearch.SearchType.RECURSIVE));
        Assert.assertEquals(0, BinarySearch.search(new int[]{234, 345, 678, 987}, 234,BinarySearch.SearchType.RECURSIVE));

        Assert.assertEquals(2, BinarySearch.search(new int[]{1, 2, 3, 4}, 3, BinarySearch.SearchType.ITERATIVE));
        Assert.assertEquals(-1, BinarySearch.search(new int[]{1, 2, 4, 3}, 3,BinarySearch.SearchType.ITERATIVE));
        Assert.assertEquals(0, BinarySearch.search(new int[]{234, 345, 678, 987}, 234,BinarySearch.SearchType.ITERATIVE));


    }

    @Test
    public void testFindMinimum(){
        Assert.assertEquals(1, BinarySearch.findMinimum(new int[]{4,5,1,2,3}));
        Assert.assertEquals(1, BinarySearch.findMinimum(new int[]{1,2,3}));
        Assert.assertEquals("min on the right",1, BinarySearch.findMinimum(new int[]{3,4,5,6,7,8,1,2}));
        Assert.assertEquals("min on the left",1, BinarySearch.findMinimum(new int[]{9,1,2,3,4,5,6,7,8}));
        Assert.assertEquals("min in the middle",1, BinarySearch.findMinimum(new int[]{3,1,2}));
        Assert.assertEquals("one element",1, BinarySearch.findMinimum(new int[]{1}));
    }

    @Test
    public void testSearchRotatedArray() throws Exception {
        Assert.assertEquals(1, BinarySearch.searchRotatedArray(new int[]{4,1,2,3}, 1));
        Assert.assertEquals(5, BinarySearch.searchRotatedArray(new int[]{4,5,6,7,8,1,2,3}, 1));
        Assert.assertEquals(-1, BinarySearch.searchRotatedArray(new int[]{4,5,6,7,8,1,2,3}, 11));
        Assert.assertEquals(-1, BinarySearch.searchRotatedArray(new int[]{4,5,6,7,8,1,2,3}, 11));
        Assert.assertEquals(0, BinarySearch.searchRotatedArray(new int[]{4}, 4));
    }
}
