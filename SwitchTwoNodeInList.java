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
public class SwitchTwoNodeInList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy;
        ListNode front = dummy;
        while (n-- > 1) {
            if (m-- > 1)
                back = back.next;
            front = front.next;
        }
        if (back.next == front) {
            back.next = front.next;
            front.next = front.next.next;
            back.next.next = front;
        } else {
            ListNode temp = back.next.next;
            back.next.next = front.next.next;
            front.next.next = temp;
            temp = front.next;
            front.next = back.next;
            back.next = temp;
        }
        return dummy.next;
    }
}
