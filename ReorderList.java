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
public class ReorderList {
    private void reverse(ListNode node) {
        ListNode node2 = node.next;
        node.next = null;            // critical: this node will become the very last
        while (node2 != null) {
            ListNode nextNode = node2.next;
            node2.next = node;
            node = node2;
            node2 = nextNode;
        }
    }
    
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse the right side (if the total length is odd, reversing the right side from the next node)
        if (fast.next == null)
            reverse(slow);
        else {
            fast = fast.next;
            reverse(slow.next);
        }
        
        // reorder the list
        while (head != slow) {
            ListNode nextHead = head.next;
            head.next = fast;
            fast = fast.next;
            head.next.next = nextHead;
            head = nextHead;
        }
    }
}
