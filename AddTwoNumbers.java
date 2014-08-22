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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode head = new ListNode(0);
        ListNode itr = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            itr.next = new ListNode((carry + l1.val + l2.val) % 10);
            carry = (carry + l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            itr = itr.next;
        }
        itr.next = (l1 != null) ? l1 : l2;
        while (carry > 0 && itr.next != null) {
            int newVal = carry + itr.next.val;
            itr.next.val = newVal % 10;
            carry = newVal / 10;
            itr = itr.next;
        }
        if (carry > 0)
            itr.next = new ListNode(1);
        return head.next;
    }
}
