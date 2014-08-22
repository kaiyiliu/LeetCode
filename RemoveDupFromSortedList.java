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
public class RemoveDupFromSortedList {
    // notice to ensure that pointer is not null when moving ahead
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode itr = head;
        while (itr != null && itr.next != null) {
            ListNode ahead = itr;
            while (ahead.next != null && ahead.next.val == ahead.val)
                ahead = ahead.next;
            itr.next = ahead.next;
            itr = itr.next;
        }
        return head;
    }
}
