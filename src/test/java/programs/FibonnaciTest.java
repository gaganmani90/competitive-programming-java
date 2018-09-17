package programs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/17/18
 */
public class FibonnaciTest {

    @Test
    public void get(){
        //0, 1, 1, 2 , 3, 5, 8, 13, 21, 34
        Assert.assertEquals(2, Fibonnaci.get(4));
        Assert.assertEquals(34, Fibonnaci.get(10));
        Assert.assertEquals(377, Fibonnaci.get(15));
    }

    @Test
    public void get_recursive(){
        Assert.assertEquals(2, Fibonnaci.get_recursive(4));
        Assert.assertEquals(-1, Fibonnaci.get_recursive(0));
        Assert.assertEquals(34, Fibonnaci.get(10));
    }
}
