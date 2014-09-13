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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        while (head.next != null) {
            ListNode itr = dummy;
            int val = head.next.val;
            while (itr != head) {
                if (val < itr.next.val)
                    break;
                itr = itr.next;
            }
            if (itr == head) {
                head = head.next;
            } else {
                ListNode temp = itr.next;
                itr.next = head.next;
                head.next = head.next.next;
                itr.next.next = temp;
            }
        }
        return dummy.next;
    }
}
