package datastructure.linkedlist;

public class DoublyListNode {

    public int val;
    public DoublyListNode next, prev;
    public DoublyListNode(int val) {this.val = val;}

    DoublyListNode(int val, DoublyListNode prev, DoublyListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
