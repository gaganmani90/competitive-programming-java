package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class BinaryTreeTest {

    @Test
    public void testSortedArrayToBst(){
        Node root = BinaryTree.sortedArrayToBst(new int[]{1,2,3});
        //Assert.assertEquals(3, root.left);

       // System.out.print(BinaryTree.preOrderTraversal(root));
    }

    @Test
    public void testPreorderTraversal(){
        Node node = new Node(10);
        node.right = new Node(30);
        node.left = new Node(20);
        node.left.left = new Node(40);
        node.left.right = new Node(50);

        Assert.assertEquals(BinaryTree.TraversalType.PREORDER.toString(),"10 20 40 50 30", BinaryTree.traversal(node, BinaryTree.TraversalType.PREORDER).trim());
        Assert.assertEquals(BinaryTree.TraversalType.INORDER.toString(),"40 20 50 10 30", BinaryTree.traversal(node, BinaryTree.TraversalType.INORDER).trim());
        Assert.assertEquals(BinaryTree.TraversalType.POSTORDER.toString(),"40 50 20 30 10", BinaryTree.traversal(node, BinaryTree.TraversalType.POSTORDER).trim());
    }
}
