package dataStructure.stack;

import org.junit.Assert;

import java.util.EmptyStackException;

public class MyStack<T> {
    private StackNode<T> top;
    private int size;

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            T item = top.data;
            top = top.next;
            size--;
            return item;
        }
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.pop().intValue());
        Assert.assertEquals(2, stack.size);
        Assert.assertEquals(2, stack.peek().intValue());
        stack.pop();
        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        StackNode<T> temp = this.top;
        while(temp != null) {
            str.append(temp.data+ " ");
            temp = temp.next;
        }
        return str.toString();
    }
}
