/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SortList {
    private ListNode findMid(ListNode head) {
        ListNode mid = head;
        while (head.next != null && head.next.next != null) {
            mid = mid.next;
            head = head.next.next;
        }
        return mid;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;
        while(left != null && right != null) {
            if (left.val <= right.val) {
                itr.next = left;
                left = left.next;
            } else {
                itr.next = right;
                right = right.next;
            }
            itr = itr.next;
        }
        itr.next = (left != null) ? left : right;
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
}
