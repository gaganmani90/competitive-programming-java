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
        Assert.assertEquals("1234", BasicOperations.print(createLinkedList(new int[]{1, 2, 3, 4})));
        Assert.assertEquals("112233", BasicOperations.print(createLinkedList(new int[]{11, 22, 33})));

    }

    @Test
    public void reverse(){
        Assert.assertEquals("321", BasicOperations.print(BasicOperations.reverse(createLinkedList(new int[]{1,2,3}))));
    }

    private Node createLinkedList(int[] arr) {
        Node head, current ;
        head = current = null;

        for (int i = 0; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            if(head == null){
                head = temp;
            }
            else{
                current.next = temp;
            }
            current = temp;
        }
        return head;
    }
}
