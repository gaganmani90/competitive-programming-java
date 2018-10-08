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
     * TODO: Removes current node
     *
     * @return
     */
    int remove() {
        return -1;
    }
}
