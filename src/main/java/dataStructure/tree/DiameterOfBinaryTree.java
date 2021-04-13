package dataStructure.tree;

public class DiameterOfBinaryTree {


    public static int diameter(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = HeightOfBinaryTree.height(root.left);
        int rightHeight = HeightOfBinaryTree.height(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }
}
