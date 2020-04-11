package dataStructure.tree;

public class HeightOfBinaryTree {

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }

}
