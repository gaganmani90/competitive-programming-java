package dataStructure.tree;

import org.junit.Assert;

import java.util.Stack;

public class BSTBackwardIterator {
    Stack<Node> stackNodes;
    Node curr;

    public BSTBackwardIterator(Node root) {
        stackNodes = new Stack<>();
        curr = root;
        //keep pushing all right nodes
        while (curr != null) {
            stackNodes.push(curr);
            curr = curr.right;
        }

    }

    /**
     * @return the prev larger node
     */
    public int prev() {
        //does next have right child
        curr = stackNodes.peek().left;
        int data = stackNodes.pop().data;

        //if yes then push all its left children into the stack
        while (curr != null) {
            stackNodes.push(curr);
            curr = curr.right;
        }
        return data;
    }


    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stackNodes.size() != 0;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.right = new Node(20);
        root.right.left = new Node(9);

        BSTBackwardIterator iterator = new BSTBackwardIterator(root);

        Assert.assertEquals(20, iterator.prev());
        Assert.assertEquals(15, iterator.prev());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(9, iterator.prev());
        Assert.assertEquals(7, iterator.prev());
        Assert.assertEquals(3, iterator.prev());
    }
}
