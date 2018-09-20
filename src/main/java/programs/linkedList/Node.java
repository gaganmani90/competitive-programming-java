package programs.linkedList;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class Node {
     int data;
     Node next;
     Node prev;

     public Node(int data){
         this.data = data;
     }

}
