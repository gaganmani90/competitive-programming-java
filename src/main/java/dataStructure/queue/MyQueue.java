package dataStructure.queue;

import org.junit.Assert;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private QueueNode<T> first; //need to remove this item
    private QueueNode<T> last; //need to add item next to it
    int size;

    public void add(T data) {
        QueueNode<T> item = new QueueNode<>(data);
        if (last != null) {
            last.next = item;
        }
        last = item;
        if (first == null) { //first time
            first = last;
        }
        size++;
    }

    /**
     * Removes first item from list
     *
     * @return
     */
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) { // no items remaining in list
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        Assert.assertEquals(4, queue.size);
        Assert.assertEquals(1, queue.remove().intValue());
        Assert.assertEquals(2, queue.peek().intValue());
    }
}
