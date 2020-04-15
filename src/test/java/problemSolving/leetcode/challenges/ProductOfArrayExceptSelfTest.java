package problemSolving.leetcode.challenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void productExceptSelf() {
        Assert.assertEquals("[24, 12, 8, 6]", Arrays.toString(ProductOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4})));
        Assert.assertEquals("[0, 0]", Arrays.toString(ProductOfArrayExceptSelf.productExceptSelf(new int[]{0,0})));
        Assert.assertEquals("[0, 1]", Arrays.toString(ProductOfArrayExceptSelf.productExceptSelf(new int[]{1,0})));
        Assert.assertEquals("[0]", Arrays.toString(ProductOfArrayExceptSelf.productExceptSelf(new int[]{0})));
    }
}