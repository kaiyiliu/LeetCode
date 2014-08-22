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
public class PartitionListInplace {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode tail = head;
        ListNode itr = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        for (int i = 1; i <= len; i++) {
            if (itr.val <= x) {
                itr = itr.next;
            } else {
                tail.next = itr;
                if (head == itr)
                    head = head.next;
                itr = itr.next;
                tail = tail.next;
                tail.next = null;
            }
        }
        return head;
    }
}
