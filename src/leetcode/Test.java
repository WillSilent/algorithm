package leetcode;

import datastructure.linkedlist.DoublyListNode;
import datastructure.linkedlist.MyLinkedList;

public class Test {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(2);
        list.deleteAtIndex(1);
        System.out.println(printList(list.head));









        list.addAtIndex(0,10);
        list.addAtIndex(0,20);
        list.addAtIndex(0,30);
        System.out.println(printList(list.head));



        list.addAtHead(1);
        list.addAtTail(3);
        System.out.println(printList(list.head));

        list.addAtIndex(1,2);
        System.out.println(printList(list.head));

        int res = list.get(1);
        System.out.println(res);

        list.deleteAtIndex(0);
        System.out.println(printList(list.head));

        res = list.get(0);
        System.out.println(res);
    }

    public static String printList(DoublyListNode head) {
        StringBuilder res = new StringBuilder();
        DoublyListNode cur = head;
        while(cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }

        res.append("NULL");
        return res.toString();
    }

}
