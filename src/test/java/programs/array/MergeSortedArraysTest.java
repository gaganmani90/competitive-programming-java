package programs.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author gagamani
 * @date 9/15/18
 */
public class MergeSortedArraysTest {

    @Test
    public void mergeByInsertion() {
        Assert.assertEquals("[1, 2, 3, 4, 4, 5, 6, 8]", Arrays.toString(MergeSortedArrays.mergeByInsertion(new int[]{1, 3, 4, 5}, new int[]{2, 4, 6, 8})));
        Assert.assertEquals("[0, 1, 3, 21]", Arrays.toString(MergeSortedArrays.mergeByInsertion(new int[]{1, 3}, new int[]{0, 21})));
    }


    @Test
    public void byMergeSort() {
        Assert.assertEquals("[1, 2, 3, 4, 4, 5, 6, 8]", Arrays.toString(MergeSortedArrays.byMergeSort(new int[]{1, 3, 4, 5}, new int[]{2, 4, 6, 8})));
        Assert.assertEquals("[0, 1, 3, 21]", Arrays.toString(MergeSortedArrays.byMergeSort(new int[]{1, 3}, new int[]{0, 21})));
    }

    @Test
    public void mergeManyArrays() {
        Assert.assertEquals("[1, 2, 3, 4, 4, 5, 6, 8]", Arrays.toString(MergeSortedArrays.MergeManyArrays.mergeArrays
                (new int[][]{{1, 3, 4, 5}, new int[]{2, 4, 6, 8}})));

        Assert.assertEquals("[1, 2, 3, 4, 4, 5, 6, 8, 21, 22, 23, 24]",
                Arrays.toString(MergeSortedArrays.MergeManyArrays.mergeArrays
                        (new int[][]{{1, 3, 4, 5},
                                new int[]{2, 4, 6, 8},
                                new int[]{21, 22, 23, 24}
                        })));

        Assert.assertEquals("[-5, -4, -3, -2, 1, 2, 3, 4, 4, 5, 6, 8]",
                Arrays.toString(MergeSortedArrays.MergeManyArrays.mergeArrays
                        (new int[][]{{1, 3, 4, 5},
                                new int[]{2, 4, 6, 8},
                                new int[]{-5, -4, -3, -2}
                        })));
    }
}
