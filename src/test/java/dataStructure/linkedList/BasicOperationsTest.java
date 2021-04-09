package dataStructure.linkedList;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/20/18
 */
@Slf4j
public class BasicOperationsTest {


    @Test
    public void reverse() {
        //Assert.assertEquals("321", BasicOperations.arrayToLinkedList(BasicOperations.reverse(BasicOperations.arrayToLinkedList(new int[]{1,2,3}))));
    }

    @Test
    public void delete() {
        Node node = BasicOperations.arrayToLinkedList(new int[]{1, 2, 3});
        log.info(node.toString());
        BasicOperations.delete(node, 2);
        Assert.assertEquals("1 3", BasicOperations.delete(node, 2).toString());
        log.info(node.toString());
    }

    @Test
    public void deleteDuplicate() {
        Assert.assertEquals("1 2 3", BasicOperations.deleteDuplicate(BasicOperations.arrayToLinkedList(new int[]{1, 2, 3, 1})).toString());
        Assert.assertEquals("1", BasicOperations.deleteDuplicate(BasicOperations.arrayToLinkedList(new int[]{1, 1, 1, 1})).toString());
    }

}
