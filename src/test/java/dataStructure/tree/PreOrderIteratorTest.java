package dataStructure.tree;

import dataStructure.tree.iterator.PreOrderIterator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PreOrderIteratorTest {

    @Test
    public void test(){

        BinaryTreeNode root = createTree();
        PreOrderIterator preOrderIterator = new PreOrderIterator(root);
        Assert.assertEquals("current node is root", 20, preOrderIterator.current());
        Assert.assertEquals(20, preOrderIterator.next());
        Assert.assertEquals(8, preOrderIterator.next());
        Assert.assertEquals(4, preOrderIterator.next());
        Assert.assertEquals(3, preOrderIterator.next());
        Assert.assertEquals(12, preOrderIterator.next());
        Assert.assertEquals(true, preOrderIterator.hasNext());
        Assert.assertEquals(10, preOrderIterator.next());
        Assert.assertEquals(14, preOrderIterator.next());
        Assert.assertEquals(22, preOrderIterator.next());
        Assert.assertEquals(false, preOrderIterator.hasNext());

    }

    @Ignore
    @Test
    public void testRemove(){
        BinaryTreeNode root = createTree();
        PreOrderIterator preOrderIterator = new PreOrderIterator(root);

        preOrderIterator.next(); //20
        preOrderIterator.next(); //8
        preOrderIterator.next(); //4
        Assert.assertEquals("removal of node with one child node",4, preOrderIterator.remove());
        Assert.assertEquals("current node is changed after removal of its parent",3, preOrderIterator.current());
        preOrderIterator.next();
        Assert.assertEquals(12, preOrderIterator.current());

        preOrderIterator = new PreOrderIterator(root);
        preOrderIterator.next();
        preOrderIterator.next();
        preOrderIterator.next();
        preOrderIterator.next();
        Assert.assertEquals("reached to leaf node",3, preOrderIterator.current());
        Assert.assertEquals("removal of leaf node",3, preOrderIterator.remove());
        Assert.assertEquals("current node is pointing to remove's node's parent",4, preOrderIterator.current());//TODO
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
