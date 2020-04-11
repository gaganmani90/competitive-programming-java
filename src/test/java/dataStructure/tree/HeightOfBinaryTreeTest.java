package dataStructure.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeightOfBinaryTreeTest {

    @Test
    public void height() {
        Assert.assertEquals(4, HeightOfBinaryTree.height(createTree()));
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