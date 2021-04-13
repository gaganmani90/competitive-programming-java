package dataStructure.tree;

/**
 * Find lowest common ancestor in a BST
 *
 * @author gagamani
 * @date 9/27/18
 */
public class LowestCommonAncestor {

    static int lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {

        if (n1 == null || n2 == null || root == null) {
            return -1;
        }

        return lcaUtil(root, n1, n2).data;

    }

    /**
     *
     * @param currNode
     * @param n1
     * @param n2
     * @return
     */
    private static BinaryTreeNode lcaUtil(BinaryTreeNode currNode, BinaryTreeNode n1, BinaryTreeNode n2) {

        if (currNode == null) {
            return null;
        }

        //If n1, n2 both are greater than current node than LCA lies to the right
        if (n1.compareTo(currNode) > 0 && n2.compareTo(currNode) > 0) {
            return lcaUtil(currNode.right, n1, n2);
        }

        if (n1.compareTo(currNode) < 0 && n2.compareTo(currNode) < 0) {
            return lcaUtil(currNode.left, n1, n2);
        }

        return currNode;
    }


}
