package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class DiameterOfBinaryTreeTest {

    @Test
    public void diameter() {
        BinaryTreeNode root = BinaryTreeUtil.arrayToBinaryTree(new int[]{1,2,3,4,5});
        Assert.assertEquals(3, DiameterOfBinaryTree.diameter(root));
    }
}