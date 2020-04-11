package dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class BasicOperationsTest {


    @Test
    public void print() {
        Assert.assertEquals("", BasicOperations.print(null));
        Assert.assertEquals("1234", BasicOperations.print(BasicOperations.arrayToLinkedList(new int[]{1, 2, 3, 4})));
        Assert.assertEquals("112233", BasicOperations.print(BasicOperations.arrayToLinkedList(new int[]{11, 22, 33})));

    }

    @Test
    public void reverse(){
        Assert.assertEquals("321", BasicOperations.print(BasicOperations.reverse(BasicOperations.arrayToLinkedList(new int[]{1,2,3}))));
    }

}
