package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class LowestCommonAncestorTest {

    @Test
    public void testLowestCommonAncestor(){

        BinaryTreeNode root = createTree();
        Assert.assertEquals(12, LowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode(14), new BinaryTreeNode(10)));
        Assert.assertEquals(8, LowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode(14), new BinaryTreeNode(8)));
        Assert.assertEquals(20, LowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode(10), new BinaryTreeNode(22)));
        Assert.assertEquals(-1, LowestCommonAncestor.lowestCommonAncestor(root, new BinaryTreeNode(10), null));

    }

    /**
     *
     *          20
     *        /    \
     *      8       22
     *    /   \
     *   4    12
     *       /   \
     *     10    14
     * @return
     */
    private BinaryTreeNode createTree(){
        BinaryTreeNode node = new BinaryTreeNode(20);
        node.right = new BinaryTreeNode(22);
        node.left = new BinaryTreeNode(8);
        node.left.left = new BinaryTreeNode(4);
        node.left.right = new BinaryTreeNode(12);
        node.left.right.right = new BinaryTreeNode(14);
        node.left.right.left = new BinaryTreeNode(10);


        return node;
    }

}
