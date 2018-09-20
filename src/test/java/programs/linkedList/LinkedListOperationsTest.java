package programs.linkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class LinkedListOperationsTest {


    @Test
    public void print() {
        Assert.assertEquals("", LinkedListOperations.print(null));
        Assert.assertEquals("1234", LinkedListOperations.print(createLinkedList(new int[]{1, 2, 3, 4})));
        Assert.assertEquals("112233", LinkedListOperations.print(createLinkedList(new int[]{11, 22, 33})));

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
