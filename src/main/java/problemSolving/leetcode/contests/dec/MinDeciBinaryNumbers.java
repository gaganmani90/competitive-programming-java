package problemSolving.leetcode.contests.dec;

import org.junit.Assert;

public class MinDeciBinaryNumbers {
    public int minPartitions(String n) {
        int maxDigit = Integer.MIN_VALUE;

        for(char c : n.toCharArray()) {
            int num = Integer.parseInt(c+"");
            if(maxDigit < num) {
                maxDigit = num;
            }
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        MinDeciBinaryNumbers minDeciBinaryNumbers = new MinDeciBinaryNumbers();
        Assert.assertEquals(3, minDeciBinaryNumbers.minPartitions("32"));
        Assert.assertEquals(8, minDeciBinaryNumbers.minPartitions("82734"));
        Assert.assertEquals(9, minDeciBinaryNumbers.minPartitions("27346209830709182346"));
    }
}
