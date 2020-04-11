package dataStructure.linkedList;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class BasicOperations {


    /**
     * input - 1 2 3 4
     * output - 4 3 2 1
     * @param node
     * @return
     */
    static Node reverse(Node node) {
        Node curr = node;
        Node next;
        Node prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;

        return node;
    }

    /**
     * Util method useful for unit tests
     * @param arr
     * @return
     */
    public static Node arrayToLinkedList(int[] arr) {
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
