package dataStructure.tree;


import java.util.Stack;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class BinaryTreeUtil {


    /**
     * Given soprted array, create minimal height BST
     *
     * @param arr sprted array
     * @return
     */
    public static BinaryTreeNode createMinimalBST(int[] arr) {
        return createMinimalBSTUtil(arr, 0, arr.length - 1);
    }

    private static BinaryTreeNode createMinimalBSTUtil(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTreeNode node = new BinaryTreeNode(arr[mid]);
        node.left = createMinimalBSTUtil(arr, start, mid - 1);
        node.right = createMinimalBSTUtil(arr, mid + 1, end);
        return node;
    }

    /**
     * TODO: complete this
     * Array to binary tree conversion in level order
     * Example: {1, 2, 3, 4, 5, 6}
     * Binary tree would be :
     * 1
     * / \
     * 2   3
     * / \ /
     * 4  5 6
     *
     * @param tree
     * @return
     */
    public static BinaryTreeNode arrayToBinaryTree(int[] tree) {
        return insertLevelOrder(tree, new BinaryTreeNode(tree[0]), 0);
    }

    private static BinaryTreeNode insertLevelOrder(int[] arr, BinaryTreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            BinaryTreeNode temp = new BinaryTreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    /**
     * 1.
     * Binary tree traversal
     *
     * @param node
     * @param traversalType
     * @return
     */
    public static String traversal(BinaryTreeNode node, TraversalType traversalType) {
        switch (traversalType) {
            case PREORDER:
                return preOrderTraversal(node);
            case POSTORDER:
                return postOrderTraversal(node);
            default:
                return inOrderTraversal(node);
        }

    }


    /**
     * 2.
     * Minimum BST value
     *
     * @param node
     * @return
     */
    public static int minimumBSTValue(BinaryTreeNode node) {
        if (node == null) {
            return -1;
        } else if (node.left == null) {
            return node.data;
        }
        return minimumBSTValue(node.left);
    }

    /**
     * 3.
     * Validates binary search tree
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(BinaryTreeNode root) {
        return validBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 4.
     * the minimum value in right subtree is successor
     *
     * @param node
     * @param key
     * @return
     */
    public static int bstSuccessor(BinaryTreeNode node, int key) {
        //find the key
        if (node.data == key) {
            if (node.right != null) {
                BinaryTreeNode tmp = node.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                return tmp.data;
            }
        } else if (key > node.data) {
            return bstSuccessor(node.right, key);
        } else if (key < node.data) {
            return bstSuccessor(node.left, key);
        }
        return key;
    }

    /**
     * 5.
     * K th smallest element in BST
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(BinaryTreeNode root, int k) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        //use inorder traversal and keep track of count
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.data;
            }
            root = root.right;
        }

    }


    private static boolean validBSTUtil(BinaryTreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data < min || node.data > max) {
            return false;
        }

        return validBSTUtil(node.left, min, node.data - 1) && validBSTUtil(node.right, node.data + 1, max);
    }

    public static String preOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return "";
        }
        return node.toString().concat(preOrderTraversal(node.left)).concat(preOrderTraversal(node.right));

    }

    public static String inOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return "";
        }
        return inOrderTraversal(node.left).concat(node.toString()).concat(inOrderTraversal(node.right));

    }

    public static String postOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return "";
        }
        return postOrderTraversal(node.left).concat(postOrderTraversal(node.right)).concat(node.toString());

    }


    enum TraversalType {
        PREORDER, INORDER, POSTORDER
    }
}
