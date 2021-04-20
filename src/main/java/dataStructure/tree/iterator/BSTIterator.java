package dataStructure.tree.iterator;

import dataStructure.tree.BinaryTreeNode;
import org.junit.Assert;

import java.util.Stack;

/**
 * curr(): returns the pointer to current element.
 * next(): iterates to the next smallest element in the Binary Search Tree.
 * isEnd(): returns true if there no node left to traverse else false.
 */
public class BSTIterator {
    Stack<BinaryTreeNode> stackNodes;
    BinaryTreeNode curr;

    public BSTIterator(BinaryTreeNode root) {
        stackNodes = new Stack<>();
        curr = root;
        //keep pushing all left nodes
        while (curr != null) {
            stackNodes.push(curr);
            curr = curr.left;
        }

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        //does next have right child
        curr = stackNodes.peek().right;
        int data = stackNodes.pop().data;

        //if yes then push all its left children into the stack
        while (curr != null) {
            stackNodes.push(curr);
            curr = curr.left;
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

        BSTIterator iterator = new BSTIterator(root);

        Assert.assertEquals(3, iterator.next());
        Assert.assertEquals(7, iterator.next());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(9, iterator.next());
        Assert.assertEquals(15, iterator.next());
        Assert.assertEquals(20, iterator.next());
    }
}
