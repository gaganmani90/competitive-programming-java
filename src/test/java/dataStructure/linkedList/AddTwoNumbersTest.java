package dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers() {
        Assert.assertEquals("2 4 6", AddTwoNumbers.addTwoNumbers
                (BasicOperations.arrayToLinkedList(new int[]{1,2,3}),
                        BasicOperations.arrayToLinkedList(new int[]{1,2,3})).
                toString());

        Assert.assertEquals("2 5 6", AddTwoNumbers.addTwoNumbers
                (BasicOperations.arrayToLinkedList(new int[]{11,2,3}),
                        BasicOperations.arrayToLinkedList(new int[]{1,2,3})).
                toString());

        Assert.assertEquals("2 2 3", AddTwoNumbers.addTwoNumbers
                (BasicOperations.arrayToLinkedList(new int[]{1,2,3}),
                        BasicOperations.arrayToLinkedList(new int[]{1})).
                toString());
    }

    @Test
    public void addFromTail() {
        Assert.assertEquals("2 4 6", AddTwoNumbers.addFromTail
                (BasicOperations.arrayToLinkedList(new int[]{1,2,3}),
                        BasicOperations.arrayToLinkedList(new int[]{1,2,3})).
                toString());

        Assert.assertEquals("1 1 2 2", AddTwoNumbers.addFromTail
                (BasicOperations.arrayToLinkedList(new int[]{1,2,3}),
                        BasicOperations.arrayToLinkedList(new int[]{9,9,9})).
                toString());

        Assert.assertEquals("1 3 2", AddTwoNumbers.addFromTail
                (BasicOperations.arrayToLinkedList(new int[]{1,2,3}),
                        BasicOperations.arrayToLinkedList(new int[]{9})).
                toString());
    }
}