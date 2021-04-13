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
        while (!originalStack.isEmpty()) {
            int temp = 0;
            //if next item is smaller then directly insert
            if (sortedStack.isEmpty() || originalStack.peek() < sortedStack.peek()) {
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
        stack.push(21);
        stack.push(31);
        stack.push(12);

        MyStack<Integer> sortedStack = sort(stack);
        Assert.assertEquals(1, sortedStack.pop().intValue());
        Assert.assertEquals(12, sortedStack.pop().intValue());
        Assert.assertEquals(21, sortedStack.pop().intValue());
        Assert.assertEquals(31, sortedStack.pop().intValue());
    }
}
