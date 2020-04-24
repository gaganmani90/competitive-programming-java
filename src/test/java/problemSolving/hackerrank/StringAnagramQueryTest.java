package problemSolving.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringAnagramQueryTest {

    @Test
    public void stringAnagram() {
        List<String> dict = Arrays.asList
                (new String[]
                        {"hack","a","rank","khac","ackh","kran","rankhacker","a","ab","ba","stairs","raits"}
                );
        List<String> query = Arrays.asList
                (new String[]
                        {"a","nark","bs","hack","stair"}
                );

        Assert.assertEquals(Arrays.asList(new Integer[]{2,2,0,3,1}), StringAnagramQuery.stringAnagram(dict, query));
    }

    @Test
    public void isAnagram() {
        Assert.assertEquals(true, StringAnagramQuery.isAnagram("abc","bac"));
        Assert.assertEquals(false, StringAnagramQuery.isAnagram("abc","bacs"));
        Assert.assertEquals(false, StringAnagramQuery.isAnagram("abc","bba"));
    }
}