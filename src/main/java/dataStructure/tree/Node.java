package dataStructure.tree;

/**
 * @author gagamani
 * @date 9/27/18
 */
public class Node implements Comparable<Node>{
    Node right;
    Node left;
    int data;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node r, Node l){
        this.data = data;
        this.right = r;
        this.left = l;
    }

    @Override
    public int compareTo(Node o) {
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
