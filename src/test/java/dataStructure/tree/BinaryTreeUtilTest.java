package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class BinaryTreeUtilTest {

    @Test
    public void test_arrayToBinaryTree(){
        Node root = BinaryTreeUtil.arrayToBinaryTree(new int[]{1,2,3,4,5});
        Assert.assertEquals(1, root.data);

        Assert.assertEquals(2, root.left.data);
        Assert.assertEquals(4, root.left.left.data);
        Assert.assertEquals(5, root.left.right.data);

        Assert.assertEquals(3, root.right.data);

    }

    @Test
    public void testTraversal(){
        Node node = new Node(10);
        node.right = new Node(30);
        node.left = new Node(20);
        node.left.left = new Node(40);
        node.left.right = new Node(50);

        Assert.assertEquals(BinaryTreeUtil.TraversalType.PREORDER.toString(),"10 20 40 50 30", BinaryTreeUtil.traversal(node, BinaryTreeUtil.TraversalType.PREORDER).trim());
        Assert.assertEquals(BinaryTreeUtil.TraversalType.INORDER.toString(),"40 20 50 10 30", BinaryTreeUtil.traversal(node, BinaryTreeUtil.TraversalType.INORDER).trim());
        Assert.assertEquals(BinaryTreeUtil.TraversalType.POSTORDER.toString(),"40 50 20 30 10", BinaryTreeUtil.traversal(node, BinaryTreeUtil.TraversalType.POSTORDER).trim());
    }

    @Test
    public void testValidBST_false() {
        Node node = new Node(10);
        node.right = new Node(30);
        node.left = new Node(20);
        node.left.left = new Node(40);
        node.left.right = new Node(50);

        Assert.assertTrue(BinaryTreeUtil.isValidBST(node));
    }

    @Test
    public void testValidBST_true() {
        Node node = new Node(20);
        node.right = new Node(30);
        node.left = new Node(10);
        node.left.left = new Node(5);
        node.left.right = new Node(11);
        node.right.right = new Node(31);

        Assert.assertTrue(BinaryTreeUtil.isValidBST(node));
    }

}
