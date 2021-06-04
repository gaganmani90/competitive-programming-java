package dataStructure.tree;

import lombok.Getter;

/**
 * @author gagamani
 * @date 9/27/18
 */
@Getter
public class BinaryTreeNode implements Comparable<BinaryTreeNode>{
    public BinaryTreeNode right;
    public BinaryTreeNode left;
    public int data;

    public BinaryTreeNode(int data){
        this.data = data;
    }

    public BinaryTreeNode(int data, BinaryTreeNode r, BinaryTreeNode l){
        this.data = data;
        this.right = r;
        this.left = l;
    }

    @Override
    public int compareTo(BinaryTreeNode o) {
        if(this.data > o.data){
            return 1;
        }
        else if(this.data < o.data){
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        traversePreOrder(sb,"","", this);
        return sb.toString();
    }

    private void traversePreOrder(StringBuilder sb, String padding, String pointer, BinaryTreeNode node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getData());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeft());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRight());
        }
    }
}
