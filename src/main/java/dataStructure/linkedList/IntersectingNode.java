package dataStructure.linkedList;

import org.junit.Assert;

public class IntersectingNode {
    public static Node intersectingNode(Node n1, Node n2) {
        Node n1Temp = n1;
        Node n2Temp = n2;

        while (n1Temp != null || n2Temp != null) {
            if (n1Temp == n2Temp) return n1Temp;
            n1Temp = n1Temp == null ? n2 : n1Temp.next;
            n2Temp = n2Temp == null ? n1 : n2Temp.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node common = new Node(10);
        Node commonNext = new Node(11);
        Node head2 = new Node(2);
        head2.next = common;
        common.next = commonNext;
        head1.next = common;

        Assert.assertEquals("10 11", intersectingNode(head1, head2).toString());
    }
}
