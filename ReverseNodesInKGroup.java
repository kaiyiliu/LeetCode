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
public class ReverseNodesInKGroup {
    // noticed that the link will be broken each time be careful

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy;
        ListNode front = dummy;
        while (front != null) {
            if (back != front) {
                ListNode nextBack = back.next;
                ListNode p1 = back.next;
                ListNode p2 = p1.next;
                while (p1 != front) {
                    ListNode p3 = p2.next;
                    p2.next = p1;
                    p1 = p2;
                    p2 = p3;
                }
                back.next.next = p2;
                back.next = front;
                back = nextBack;
                front = back;
            }
            for (int i = 1; i <= k; i++) {
                if (front == null)
                    break;
                front = front.next;
            }
        }
        return dummy.next;
    }
}
