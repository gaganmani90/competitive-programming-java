package dataStructure.tree;

import org.omg.CORBA.NO_IMPLEMENT;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class BinaryTree {

    /**
     * TODO: complete this
     * Array to BST conversion provided given array is sorted
     * @param sortedArray
     * @return
     */
    static Node sortedArrayToBst(int[] sortedArray) {
        if (sortedArray == null) {
            return null;
        }
        if (sortedArray.length == 1) {
            return new Node(sortedArray[0]);
        }

        return arrayToBstUtil(sortedArray, 0, sortedArray.length - 1);
    }

    private static Node arrayToBstUtil(int[] arr, int start, int end) {

        //base case
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(mid);

        node.left = arrayToBstUtil(arr, start, mid - 1);
        node.right = arrayToBstUtil(arr, mid + 1, end);

        return node;

    }

    /**
     * Binary tree traversal
     * @param node
     * @param traversalType
     * @return
     */
    static String traversal(Node node, TraversalType traversalType) {
        switch (traversalType) {
            case PREORDER:
                return preOrderTraversal(node);
            case INORDER:
                return inOrderTraversal(node);
            case POSTORDER:
                return postOrderTraversal(node);
            default:
                return null;
        }

    }

    private static String preOrderTraversal(Node node) {
        if (node == null) {
            return "";
        }
        return node.toString().concat(preOrderTraversal(node.left)).concat(preOrderTraversal(node.right));

    }

    private static String inOrderTraversal(Node node) {
        if (node == null) {
            return "";
        }
        return inOrderTraversal(node.left).concat(node.toString()).concat(inOrderTraversal(node.right));

    }

    private static String postOrderTraversal(Node node) {
        if (node == null) {
            return "";
        }
        return postOrderTraversal(node.left).concat(postOrderTraversal(node.right)).concat(node.toString());

    }



    enum TraversalType {
        PREORDER, INORDER, POSTORDER
    }
}
