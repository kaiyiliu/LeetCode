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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lIter = left;
        ListNode rIter = right;
        while (head != null) {
            if (head.val < x) {
                lIter.next = new ListNode(head.val);
                lIter = lIter.next;
            } else {
                rIter.next = new ListNode(head.val);
                rIter = rIter.next;
            }
            head = head.next;
        }
        lIter.next = right.next;
        return left.next;
    }
}
