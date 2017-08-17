package question1;

import org.junit.Test;
import question1.Node;
import question1.NodeUtils;

import static org.junit.Assert.*;

/**
 * Created by Jiawei on 8/15/17.
 */
public class NodeUtilsTest {

    @Test
    public void reverseNullList() throws Exception {
        Node head = null;
        Node res = NodeUtils.reverseList(head);
        assertNull(res);

        System.out.println("reverseNullList is successful");
    }

    @Test
    public void reverseOneNodeList() throws Exception {
        Node head = new Node();
        head.value = 1;
        head.next = null;

        Node res = NodeUtils.reverseList(head);
        assertNotNull(res);
        assertEquals(res.value, 1);
        assertNull(res.next);

        System.out.println("reverseOneNodeList is successful");
    }

    @Test
    public void reverseMultiNodesList() throws Exception {
        Node head = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        head.value = 1;
        head.next = node1;

        node1.value = 2;
        node1.next = node2;

        node2.value = 3;

        Node res = NodeUtils.reverseList(head);
        assertNotNull(res);
        assertEquals(res.value, 3);
        assertEquals(res.next.value, 2);
        assertEquals(res.next.next.value, 1);
        assertNull(res.next.next.next);

        System.out.println("reverseMultiNodesList is successful");
    }

}