package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class BinaryTreeUtilTest {

    @Test
    public void createMinimalBST() {
        BinaryTreeNode root = BinaryTreeUtil.createMinimalBST(new int[]{1,2,3,4,5});
        Assert.assertEquals(3, root.data);
        Assert.assertEquals(1, root.left.data);
        Assert.assertEquals(4, root.right.data);

        Assert.assertEquals(2, root.left.right.data);
        Assert.assertEquals(5, root.right.right.data);

        Assert.assertEquals(3, HeightOfBinaryTree.height(root));
    }

    @Test
    public void test_arrayToBinaryTree() {
        BinaryTreeNode root = BinaryTreeUtil.arrayToBinaryTree(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(1, root.data);

        Assert.assertEquals(2, root.left.data);
        Assert.assertEquals(4, root.left.left.data);
        Assert.assertEquals(5, root.left.right.data);

        Assert.assertEquals(3, root.right.data);

    }

    @Test
    public void testTraversal() {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.right = new BinaryTreeNode(30);
        node.left = new BinaryTreeNode(20);
        node.left.left = new BinaryTreeNode(40);
        node.left.right = new BinaryTreeNode(50);

        Assert.assertEquals(BinaryTreeUtil.TraversalType.PREORDER.toString(), "10 20 40 50 30", BinaryTreeUtil.traversal(node, BinaryTreeUtil.TraversalType.PREORDER).trim());
        Assert.assertEquals(BinaryTreeUtil.TraversalType.INORDER.toString(), "40 20 50 10 30", BinaryTreeUtil.traversal(node, BinaryTreeUtil.TraversalType.INORDER).trim());
        Assert.assertEquals(BinaryTreeUtil.TraversalType.POSTORDER.toString(), "40 50 20 30 10", BinaryTreeUtil.traversal(node, BinaryTreeUtil.TraversalType.POSTORDER).trim());
    }

    @Test
    public void testValidBST_false() {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.right = new BinaryTreeNode(30);
        node.left = new BinaryTreeNode(20);
        node.left.left = new BinaryTreeNode(40);
        node.left.right = new BinaryTreeNode(50);

        Assert.assertFalse(BinaryTreeUtil.isValidBST(node));

    }

    @Test
    public void testValidBST_true() {
        BinaryTreeNode node = new BinaryTreeNode(20);
        node.right = new BinaryTreeNode(30);
        node.left = new BinaryTreeNode(10);
        node.left.left = new BinaryTreeNode(5);
        node.left.right = new BinaryTreeNode(11);
        node.right.right = new BinaryTreeNode(31);

        Assert.assertTrue(BinaryTreeUtil.isValidBST(node));
    }

    @Test
    public void minBSTValue() {
        BinaryTreeNode node = new BinaryTreeNode(20);
        node.right = new BinaryTreeNode(30);
        node.right.right = new BinaryTreeNode(31);
        node.left = new BinaryTreeNode(10);
        node.left.left = new BinaryTreeNode(5);
        node.left.right = new BinaryTreeNode(11);


        Assert.assertTrue(BinaryTreeUtil.isValidBST(node));
        Assert.assertEquals(5, BinaryTreeUtil.minimumBSTValue(node));
        Assert.assertEquals(30, BinaryTreeUtil.bstSuccessor(node, 20));
        Assert.assertEquals(31, BinaryTreeUtil.bstSuccessor(node, 30));
    }

    @Test
    public void kthSmallest() {
        BinaryTreeNode root = createBST();
        Assert.assertEquals(5, BinaryTreeUtil.kthSmallest(root, 1));
        Assert.assertEquals(11, BinaryTreeUtil.kthSmallest(root, 3));
    }

    private static BinaryTreeNode createBST() {
        BinaryTreeNode node = new BinaryTreeNode(20);
        node.right = new BinaryTreeNode(30);
        node.left = new BinaryTreeNode(10);
        node.left.left = new BinaryTreeNode(5);
        node.left.right = new BinaryTreeNode(11);
        node.right.right = new BinaryTreeNode(31);

        return node;
    }

}
