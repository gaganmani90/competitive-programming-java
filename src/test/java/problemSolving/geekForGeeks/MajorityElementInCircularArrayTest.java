package problemSolving.geekForGeeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MajorityElementInCircularArray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 23, 2018</pre>
 */
public class MajorityElementInCircularArrayTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isMajority(int[] arr, int element)
     */
    @Test
    public void testIsMajority() throws Exception {
        Assert.assertEquals(true, MajorityElementInCircularArray.isMajority
                (new int[]{0, 0, 1, 1, 0, 1, 1, 0, 0}, 3, 3, 1));

        Assert.assertEquals(false, MajorityElementInCircularArray.isMajority
                (new int[]{1, 0, 0, 1, 1, 0, 1, 0, 0}, 3, 3, 1));

        Assert.assertEquals("check for 0",true, MajorityElementInCircularArray.isMajority
                (new int[]{1, 0, 0, 1, 1, 0, 1, 0, 0}, 3, 3, 0));

        Assert.assertEquals("unequal sub arrays",false, MajorityElementInCircularArray.isMajority
                (new int[]{1, 1, 1, 1, 1}, 3, 3, 1));

        Assert.assertEquals("check for 3",true, MajorityElementInCircularArray.isMajority
                (new int[]{1,2,3,1,1,3,1,2,1,3,3,3}, 3, 3, 1));

        Assert.assertEquals("all elements equal",false, MajorityElementInCircularArray.isMajority
                (new int[]{1,2,3,1,2,3}, 2, 3, 1));

        Assert.assertEquals("all same elements",true, MajorityElementInCircularArray.isMajority
                (new int[]{4,4,4,4,4,4}, 2, 3, 4));
    }

    @Test
    public void isElementInMajority() throws Exception {
        Assert.assertEquals(false, MajorityElementInCircularArray.isElementInMajority(new int[]{1, 1, 2, 1}, 3));
        Assert.assertEquals(false, MajorityElementInCircularArray.isElementInMajority(new int[]{1, 1, 2, 1}, 5));
        Assert.assertEquals(true, MajorityElementInCircularArray.isElementInMajority(new int[]{4, 4, 2, 3}, 5));
        Assert.assertEquals(false, MajorityElementInCircularArray.isElementInMajority(new int[]{4, 4, 2, 2}, 5));
    }

} 
