package dataStructure.linkedList;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

/**
 * Implement a function to check if a linked list is a palindrome
 */
@Slf4j
public class PalindromeLinkedList {

    public static boolean isPalindrome(Node node) {
        Node middle = BasicOperations.getMiddle(node);
        Node middleReverse = BasicOperations.reverse(middle.next);
        return isReverseEqual(node, middleReverse);
    }

    private static boolean isReverseEqual(Node head, Node reverseHead) {
        while(reverseHead != null) {
            if(head.data != reverseHead.data) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Assert.assertTrue(PalindromeLinkedList.isPalindrome(BasicOperations.arrayToLinkedList(new int[]{5,4,1,4,5})));
        Assert.assertFalse(PalindromeLinkedList.isPalindrome(BasicOperations.arrayToLinkedList(new int[]{4,1,4,5})));
    }
}
