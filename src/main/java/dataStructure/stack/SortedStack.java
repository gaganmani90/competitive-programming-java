package dataStructure.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Stack;

/**
 * Sort stack by using another stack
 */
@Slf4j
public class SortedStack {
    public static MyStack<Integer> sort(MyStack<Integer> originalStack) {
        MyStack<Integer> sortedStack = new MyStack<>();
        if (sortedStack.isEmpty()) {
            sortedStack.push(originalStack.pop());
        }
        while (!originalStack.isEmpty()) {
            int temp = 0;
            //if next item is smaller then directly insert
            if (originalStack.peek() < sortedStack.peek()) {
                sortedStack.push(originalStack.pop());
            } else {
                temp = sortedStack.pop();
                sortedStack.push(originalStack.pop());
                sortedStack.push(temp);
            }
        }
        log.info(sortedStack.toString());
        return sortedStack;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        MyStack<Integer> sortedStack = sort(stack);
        Assert.assertEquals(1, sortedStack.pop().intValue());
        Assert.assertEquals(2, sortedStack.pop().intValue());
        Assert.assertEquals(3, sortedStack.pop().intValue());
    }
}
