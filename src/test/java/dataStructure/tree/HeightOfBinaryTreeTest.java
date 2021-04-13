package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class HeightOfBinaryTreeTest {

    @Test
    public void height() {
        Assert.assertEquals(4, HeightOfBinaryTree.height(createTree()));
    }

    /**
     *
     *          20
     *        /    \
     *      8       22
     *    /   \
     *   4    12
     *  /    /   \
     * 3    10    14
     * @return
     */
    private BinaryTreeNode createTree(){
        BinaryTreeNode node = new BinaryTreeNode(20);
        node.right = new BinaryTreeNode(22);
        node.left = new BinaryTreeNode(8);
        node.left.left = new BinaryTreeNode(4);
        node.left.left.left = new BinaryTreeNode(3);
        node.left.right = new BinaryTreeNode(12);
        node.left.right.right = new BinaryTreeNode(14);
        node.left.right.left = new BinaryTreeNode(10);


        return node;
    }
}