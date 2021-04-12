package dataStructure.linkedList;

import lombok.Getter;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    /**
     * Add numbers in two linked list
     * @param l1
     * @param l2
     * @return
     */
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node node = null; //head
        Node current = null;
        int carry = 0;
        int sum;
        while(l1 != null || l2 != null) {
            sum = (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0) + carry;
            carry = sum > 9 ? 1 : 0; //calculate new carry
            sum = (carry == 1) ? sum%10 : sum; //calculate sum based on new carry
            Node temp = new Node(sum);
            if(node == null) {
                node = temp;
            } else{
                current.next = temp;
            }
            current = temp;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        //edge case. add new node for carry
        if(carry == 1) {
            current.next = new Node(carry);
        }
        return node;
    }

    public static Node addFromTail(Node l1, Node l2) {
        int len1 = l1.length();
        int len2 = l2.length();

        if(len2 < len1) {
            l2 = padList(l2, len1-len2);
        } else {
            l1 = padList(l1, len2-len1);
        }

        /* Add lists */
        PartialSum sum = addListsHelper(l1, l2);

        /* If there was a carry value left over, insert this at the front of the list.
         * Otherwise, just return the linked list. */
        if (sum.carry== 0) {
            return sum.sum;
        } else {
            Node result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private static PartialSum addListsHelper(Node l1, Node l2) {
        if(l1 == null && l2 == null) {
            PartialSum partialSum = new PartialSum();
            return partialSum;
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);

        int value = l1.data + l2.data + sum.carry;

        //add node to sum list
        sum.sum = insertBefore(sum.sum, value % 10);
        sum.carry = value / 10;

        return sum;
    }

    private static Node padList(Node l1, int offset) {
        Node node = l1;
        for(int i = 0; i < offset; i++) {
            node = insertBefore(node, 0);
        }
        return node;
    }

    private static Node insertBefore(Node l1, int data) {
        Node node = new Node(data);
        if(l1 != null) {
            node.next = l1;
        }
        return node;
    }
}

@Getter
class PartialSum {
    Node sum = null;
    int carry = 0;
}
