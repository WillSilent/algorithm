package datastructure.linkedlist;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

    public static Node flatten(Node head) {
        if(head == null) {
            return null;
        }

        Node dummyHead = new Node(-1);
        Node curr = dummyHead;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();

            Node newNode = new Node(cur.val);
            newNode = curr;
            curr.next = newNode;
            curr = curr.next;

            if(cur.child != null) {
                Node res = flatten(cur.child);
                res.prev = curr;

                curr.next = res;
                curr = curr.next;

                cur.child = null;
            }

            if(cur.next != null) {
                stack.push(cur.next);
            }
        }

        Node tmp = dummyHead.next;
        tmp.prev = null;
        dummyHead.next = null;
        return tmp;
    }


}
