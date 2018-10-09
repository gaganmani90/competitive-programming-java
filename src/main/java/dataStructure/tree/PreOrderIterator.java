package dataStructure.tree;

import java.util.Stack;

public class PreOrderIterator {

    Stack<Node> stack = new Stack<>();
    Node current;

    PreOrderIterator(Node root) {
        this.current = root;
        stack.push(root);
    }

    boolean hasNext() {
        return !stack.empty();
    }

    /**
     * returns current node's value and moves pointer to next node
     * @return
     */
    int next() {
        if (!this.hasNext()) {
            return -1;
        }

        this.current = stack.pop();

        if (current.right != null) {
            stack.push(current.right);
        }

        if (current.left != null) {
            stack.push(current.left);
        }
        return current.data;
    }

    /**
     * current's node value
     * @return
     */
    int current(){
        return current.data;
    }

    /**
     * TODO: Removes current node
     *
     * @return
     */
    int remove() {
        int removed = -1;

        //leaf node
        if(current.right == null && current.left == null){
            stack.remove(current);
            removed = current.data;

            //need to point to parent node
        }
        else if(current.right == null && current.left != null){
            stack.remove(current);
            removed = current.data;
            current = current.left;
        }
        else if(current.right != null && current.left == null){
            stack.remove(current);
            removed = current.data;
            current = current.right;
        }
        else{ //when it has two children

        }
        return removed;
    }


}
