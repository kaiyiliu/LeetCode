/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedList {
    // notice the node's next changes at the end of the reverse list
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy;
        ListNode front = head;
        while (n-- > 1) {
            if (m-- > 1)
                back = back.next;
            front = front.next;
        }
        ListNode p1 = back.next;
        ListNode p2 = p1.next;
        ListNode p3 = p2;
        while (p1 != front) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        back.next.next = p2;
        back.next = p1;
        return dummy.next;
    }
}
