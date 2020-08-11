package problemSolving.leetcode.medium;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        //create an array and store the last index of each character in the string
        int[] endIndexArray = new int[26];
        for (int i = 0; i < S.length(); i++) {
            endIndexArray[S.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        //first partition
        int start = 0;
        int end = endIndexArray[S.charAt(0) - 'a'];
        //check the index
        for (int i = 1; i < S.length(); i++) {
            int starti = i;
            int endi = endIndexArray[S.charAt(i) - 'a'];
            if (end >= starti) {
                end = Math.max(end, endi);
            } else {
                result.add(end - start + 1);
                start = starti;
                end = endi;
            }
        }
        result.add(end - start + 1);
        return result;
    }

    public static void main(String[] args) {
       // Assert.assertEquals(partitionLabels("aaaa").toString(), "[4]");
        //Assert.assertEquals(partitionLabels("abc").toString(), "[1, 1, 1]");
        Assert.assertEquals(partitionLabels("ababcbacadefegdehijhklij").toString(), "[9, 7, 8]");
    }
}
