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
public class RemoveDupFromSortedList2 {
    // noticed that only when you do not delte any thing,
    // you can iterate next
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode itr = dummy;
        while (itr != null && itr.next != null && itr.next.next != null) {
            ListNode fast = itr.next;
            while (fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            if (itr.next != fast)
                itr.next = fast.next;
            else
                itr = itr.next;
        }
        return dummy.next;
    }
}
