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
public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null & l2 == null)
            return null;
        ListNode head = new ListNode(0);
        ListNode itr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                itr.next = l1;
                l1 = l1.next;
            } else {
                itr.next = l2;
                l2 = l2.next;
            }
            itr = itr.next;
        }
        itr.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
