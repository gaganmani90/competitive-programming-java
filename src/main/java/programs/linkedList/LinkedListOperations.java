package programs.linkedList;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class LinkedListOperations {


     static String print(Node node){
        StringBuilder stringBuilder = new StringBuilder();
        if(node == null){
            stringBuilder.append("");
        }
        else{
            while(node != null){
                stringBuilder.append(node.data);
                node = node.next;
            }
        }
        return stringBuilder.toString();
    }
}
