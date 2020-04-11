package dataStructure.tree;

public class HeightOfBinaryTree {

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
