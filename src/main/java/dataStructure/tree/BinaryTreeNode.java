package dataStructure.tree;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class BinaryTreeNode implements Comparable<BinaryTreeNode>{
    BinaryTreeNode right;
    BinaryTreeNode left;
    int data;

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
        return data+" ";
    }
}
