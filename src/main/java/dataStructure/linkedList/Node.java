package dataStructure.linkedList;

import lombok.ToString;

/**
 * @author gagamani
 * @date 9/20/18
 */
@ToString
public class Node {
     int data;
     Node next;
     Node prev;

     public Node(int data){
         this.data = data;
     }

}
