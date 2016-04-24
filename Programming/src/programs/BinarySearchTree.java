package programs;

import javax.swing.text.AbstractDocument.LeafElement;

public class BinarySearchTree {

	public static void main(String[] args) {
		int[] arr = {3,23,56,4,5,90,77};
		Node root = createBST(arr);
		preorderTraversal(root);
		System.out.println(find(24, root));
	}

	private static Node createBST(int[] arr){
		Node root = new Node(arr[arr.length/2]);
		for(int i=0; i<arr.length; i++){
			if(i==arr.length/2) continue;
			root.addNode(arr[i]);
		}
		return root;
	}

	private static void preorderTraversal(Node root){
		System.out.println(root.data);
		if(root.left != null){
			preorderTraversal(root.left);
		}
		if(root.right != null){
			preorderTraversal(root.right);
		}
	}

	private static boolean find(int n,Node current){
		
		while(current != null){
			if(n < current.data){
				current  =current.left;
			}else if (n > current.data){
				current  =current.right;
			}
			else{
				return true;
			}
		}
		return false;
	}
	
}

class Node{
	Node left;
	Node right;
	int data;

	public Node(int data){
		this.data = data;
	}

	public void addNode(int num){
		if(num < this.data){
			if(this.left != null){
				this.left.addNode(num);
			}
			else{
				this.left = new Node(num);
			}
		}
		else{
			if(this.right != null){
				this.right.addNode(num);
			}
			else{
				this.right = new Node(num);
			}
		}
	}
}
