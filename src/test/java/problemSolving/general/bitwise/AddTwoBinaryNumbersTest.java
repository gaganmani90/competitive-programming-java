package problemSolving.general.bitwise;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/24/18
 */
public class AddTwoBinaryNumbersTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(1, AddTwoBinaryNumbers.add("01", "00"));
        Assert.assertEquals(0, AddTwoBinaryNumbers.add("", "00"));
        Assert.assertEquals(0, AddTwoBinaryNumbers.add("", ""));
        Assert.assertEquals(2, AddTwoBinaryNumbers.add("01", "01"));
        Assert.assertEquals(30, AddTwoBinaryNumbers.add("1111", "1111"));
    }

    @Test
    public void testBinaryToDecimal() {
        Assert.assertEquals(10, AddTwoBinaryNumbers.binaryToDecimal(1010));
        Assert.assertEquals(15, AddTwoBinaryNumbers.binaryToDecimal(1111));
        Assert.assertEquals(1023, AddTwoBinaryNumbers.binaryToDecimal(1111111111));
        Assert.assertEquals(0, AddTwoBinaryNumbers.binaryToDecimal(0));
        Assert.assertEquals(0, AddTwoBinaryNumbers.binaryToDecimal(00000));
        Assert.assertEquals(64, AddTwoBinaryNumbers.binaryToDecimal(1000000));
        Assert.assertEquals(1, AddTwoBinaryNumbers.binaryToDecimal(1));
        Assert.assertEquals(2, AddTwoBinaryNumbers.binaryToDecimal(10));
    }

    @Test
    public void testDecimalToBinary() {
        Assert.assertEquals("1111", AddTwoBinaryNumbers.decimalToBinary(15));
        Assert.assertEquals("1", AddTwoBinaryNumbers.decimalToBinary(1));
        Assert.assertEquals("10", AddTwoBinaryNumbers.decimalToBinary(2));
        Assert.assertEquals("100000", AddTwoBinaryNumbers.decimalToBinary(32));
        Assert.assertEquals("invalid", AddTwoBinaryNumbers.decimalToBinary(-2));

    }
}
