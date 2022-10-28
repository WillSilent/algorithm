package datastructure.linkedlist;

public class PalindromeLinkedList {

    /**
     * 快慢双指针 + 头插法
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if(head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode firstHalf = new ListNode(head.val);

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast != null) {
                ListNode newNode = new ListNode(slow.val);
                ListNode tmp = firstHalf;
                firstHalf = newNode;
                firstHalf.next = tmp;
            }
        }

        // begin slow, and firstHalf
        while(slow != null) {
            if(slow.val != firstHalf.val) {
                return false;
            }

            slow = slow.next;
            firstHalf = firstHalf.next;
        }

        return true;
    }

}
