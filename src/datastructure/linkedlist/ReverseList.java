package datastructure.linkedlist;

public class ReverseList {

    /**
     * 一定要注意创建新节点。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode tmp = res;
            ListNode newNode = new ListNode(cur.val);

            res = newNode;
            res.next = tmp;
            cur = cur.next;
        }

        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        System.out.println(printList(head));

        ListNode res = reverseList(head);
        System.out.println(printList(res));
    }

    public static String printList(ListNode head) {
        StringBuilder s = new StringBuilder();
        ListNode cur = head;
        while(cur != null) {
            s.append(cur.val + "->");
            cur = cur.next;
        }

        s.append("NULL");
        return s.toString();
    }

}
