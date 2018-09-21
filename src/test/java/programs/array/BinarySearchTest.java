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
        Assert.assertEquals(2, BinarySearch.search(new int[]{1, 2, 3, 4}, 3));
        Assert.assertEquals(-1, BinarySearch.search(new int[]{1, 2, 4, 3}, 3));
        Assert.assertEquals(0, BinarySearch.search(new int[]{234, 345, 678, 987}, 234));
    }


} 
