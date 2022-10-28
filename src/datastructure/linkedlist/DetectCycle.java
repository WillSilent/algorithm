package datastructure.linkedlist;

//哪个节点循环节点
//	Linked List Cycle II
public class DetectCycle {
    /**
     * 1.先设置快慢指针，快的走两步，慢的走一步，等到两个指针相等时，记住该节点
     * 2.一个指针从head出发，另一个指针从上一步记住的指针出发，两个指针每次走一步，两个指针相等时即为循环开始的节点。
     * @param head
     * @return
     */

    public ListNode getInterectNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode interect = getInterectNode(head);
        if(interect == null) {
            return null;
        }

        ListNode cur = head;
        while(cur != interect) {
            cur = cur.next;
            interect = interect.next;
        }

        return cur;
    }


}
