package question1;

/**
 * Created by Jiawei on 8/15/17.
 */
public class NodeUtils {
    public static Node reverseList(Node head){
        Node prev = null;
        Node curt = head;

        while (curt != null) {
            Node temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        return prev;
    }
}
