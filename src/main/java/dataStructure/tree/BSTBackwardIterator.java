package dataStructure.tree;

import org.junit.Assert;

import java.util.Stack;

public class BSTBackwardIterator {
    Stack<BinaryTreeNode> stackNodes;
    BinaryTreeNode curr;

    public BSTBackwardIterator(BinaryTreeNode root) {
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
        BinaryTreeNode root = new BinaryTreeNode(7);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(15);
        root.right.right = new BinaryTreeNode(20);
        root.right.left = new BinaryTreeNode(9);

        BSTBackwardIterator iterator = new BSTBackwardIterator(root);

        Assert.assertEquals(20, iterator.prev());
        Assert.assertEquals(15, iterator.prev());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(9, iterator.prev());
        Assert.assertEquals(7, iterator.prev());
        Assert.assertEquals(3, iterator.prev());
    }
}
