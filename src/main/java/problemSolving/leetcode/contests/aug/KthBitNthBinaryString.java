package problemSolving.leetcode.contests.aug;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Find Kth Bit in Nth Binary String
 * User Accepted:3552
 * User Tried:4093
 * Total Accepted:3610
 * Total Submissions:6021
 * Difficulty:Medium
 * Given two positive integers n and k, the binary string  Sn is formed as follows:
 *
 * S1 = "0"
 * Si = Si-1 + "1" + reverse(invert(Si-1)) for i > 1
 * Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
 *
 * For example, the first 4 strings in the above sequence are:
 *
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 1
 * Output: "0"
 * Explanation: S3 is "0111001". The first bit is "0".
 * Example 2:
 *
 * Input: n = 4, k = 11
 * Output: "1"
 * Explanation: S4 is "011100110110001". The 11th bit is "1".
 * Example 3:
 *
 * Input: n = 1, k = 1
 * Output: "0"
 * Example 4:
 *
 * Input: n = 2, k = 3
 * Output: "1"
 */
public class KthBitNthBinaryString {
    static Map<Integer, String> binaryCache = new HashMap<>();

    public static char findKthBit(int n, int k) {
        //update cache
        String output = nthBinary(n);
        binaryCache.put(n, output);
        return output.charAt(k-1);
    }

    static String nthBinary(int n) {
        if(n==1) {
            return "0";
        }
        else if (binaryCache.containsKey(n)) {
            return binaryCache.get(n);
        } else {
            return nthBinary(n-1).concat("1").concat(reverse(invert(nthBinary(n-1))));
        }
    }


    private static String invert(String s) {
        StringBuilder invertString = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == '0') {
                invertString.append("1");
            } else {
                invertString.append("0");
            }
        }
        return invertString.toString();
    }

    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Assert.assertEquals(nthBinary(2),"011");
        Assert.assertEquals(nthBinary(4),"011100110110001");
        Assert.assertEquals(nthBinary(3),"0111001");
        //Assert.assertEquals(nthBinary(6),"0111001");
        System.out.println(findKthBit(3,1));
        System.out.println(findKthBit(4,11));
        //Assert.assertEquals(findKthBit(3,1),'0');
    }
}
