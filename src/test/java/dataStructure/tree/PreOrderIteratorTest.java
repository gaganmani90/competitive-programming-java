package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class PreOrderIteratorTest {

    @Test
    public void test(){

        Node root = createTree();
        PreOrderIterator preOrderIterator = new PreOrderIterator(root);

        Assert.assertEquals(20, preOrderIterator.next());
        Assert.assertEquals(8, preOrderIterator.next());
        Assert.assertEquals(4, preOrderIterator.next());
        Assert.assertEquals(12, preOrderIterator.next());
        Assert.assertEquals(true, preOrderIterator.hasNext());
        Assert.assertEquals(10, preOrderIterator.next());
        Assert.assertEquals(14, preOrderIterator.next());
        Assert.assertEquals(22, preOrderIterator.next());
        Assert.assertEquals(false, preOrderIterator.hasNext());

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
    private Node createTree(){
        Node node = new Node(20);
        node.right = new Node(22);
        node.left = new Node(8);
        node.left.left = new Node(4);
        node.left.right = new Node(12);
        node.left.right.right = new Node(14);
        node.left.right.left = new Node(10);


        return node;
    }
}
