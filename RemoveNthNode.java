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
public class RemoveNthNode {
    // notice the edge case where head is deleted
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1)
            return head;
        ListNode fast = head;
        ListNode beforeDel = new ListNode(0);
        beforeDel.next = head;
        while (fast != null && n-- > 0)
            fast = fast.next;
        if (n > 0)
            return head;
        while (fast != null) {
            fast = fast.next;
            beforeDel = beforeDel.next;
        }
        if (beforeDel.next == head)
            return beforeDel.next.next;
        beforeDel.next = beforeDel.next.next;
        return head;
    }
}
