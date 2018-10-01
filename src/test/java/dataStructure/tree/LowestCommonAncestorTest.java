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

        Node root = createTree();
        Assert.assertEquals(12, LowestCommonAncestor.lowestCommonAncestor(root, new Node(14), new Node(10)));
        Assert.assertEquals(8, LowestCommonAncestor.lowestCommonAncestor(root, new Node(14), new Node(8)));
        Assert.assertEquals(20, LowestCommonAncestor.lowestCommonAncestor(root, new Node(10), new Node(22)));
        Assert.assertEquals(-1, LowestCommonAncestor.lowestCommonAncestor(root, new Node(10), null));

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
