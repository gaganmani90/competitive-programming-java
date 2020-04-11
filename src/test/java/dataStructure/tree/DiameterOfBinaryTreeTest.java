package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiameterOfBinaryTreeTest {

    @Test
    public void diameter() {
        Node root = BinaryTreeUtil.arrayToBinaryTree(new int[]{1,2,3,4,5});
        Assert.assertEquals(3, DiameterOfBinaryTree.diameter(root));
    }
}