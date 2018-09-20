package programs.linkedList;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class BasicOperations {


    public static String print(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node == null) {
            stringBuilder.append("");
        } else {
            while (node != null) {
                stringBuilder.append(node.data);
                node = node.next;
            }
        }
        return stringBuilder.toString();
    }

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
}
