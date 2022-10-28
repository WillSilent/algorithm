package datastructure.linkedlist;

// 设计一个单链表出来，可以自己添加元素，获取元素，并通过下标来获取元素，和添加元素
// 或者是双链表
public class MyLinkedList {

    public DoublyListNode head;
    public int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if(index >= size) {
            return -1;
        }

        DoublyListNode cur = head;
        int i = 0;
        while(cur != null) {
            if(i == index) {
                return cur.val;
            }
            i++;
            cur = cur.next;
        }

        return -1;
    }

    public void addAtHead(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        DoublyListNode tmp = head;

        newNode.next = tmp;

        if(tmp != null)
            tmp.prev = newNode;

        head = newNode;
        size ++;
    }

    public void addAtTail(int val) {
        DoublyListNode dummyHead = new DoublyListNode(-1);
        dummyHead.next = head;

        DoublyListNode newNode = new DoublyListNode(val);
        DoublyListNode cur = head, prev = dummyHead;

        while(cur != null) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = newNode;
        newNode.prev = prev;
        head = dummyHead.next;
        size ++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }

        DoublyListNode dummyHead = new DoublyListNode(-1);
        dummyHead.next = head;

        DoublyListNode cur = head, prev = dummyHead;

        int i = 0;
        while(cur != null) {
            if(i == index) {
                break;
            }

            prev = cur;
            cur = cur.next;
            i++;
        }

        DoublyListNode newNode = new DoublyListNode(val);
        //到位置了。添加元素到cur之前
        newNode.next = cur;
        newNode.prev = prev;

        prev.next = newNode;
        if(cur != null) {
            cur.prev = newNode;
        }

        head = dummyHead.next;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index >= size) {
            return;
        }

        DoublyListNode dummyHead = new DoublyListNode(-1);
        dummyHead.next = head;

        DoublyListNode cur = head, prev = dummyHead;

        int i = 0;
        while (cur != null) {
            if (i == index) {
                break;
            }

            prev = cur;
            cur = cur.next;
            i++;
        }

        //到位置了，开始删除cur
        prev.next = cur.next;

        if (cur != null && cur.next != null) {
            cur.next.prev = prev;
            cur.prev = null;
            cur.next = null;
        }

        head = dummyHead.next;
        size--;

    }
}
