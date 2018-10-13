package dataStructure.tree;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PreOrderIteratorTest {

    @Test
    public void test(){

        Node root = createTree();
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
        Node root = createTree();
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
    private Node createTree(){
        Node node = new Node(20);
        node.right = new Node(22);
        node.left = new Node(8);
        node.left.left = new Node(4);
        node.left.left.left = new Node(3);
        node.left.right = new Node(12);
        node.left.right.right = new Node(14);
        node.left.right.left = new Node(10);


        return node;
    }
}
