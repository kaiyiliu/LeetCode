/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class sortedListToBST1 {
    public TreeNode buildTree(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        if (head.next.next == null) {
            TreeNode reNode = new TreeNode(head.next.val);
            reNode.left = new TreeNode(head.val);
            return reNode;
        }
        ListNode beforeMid = head;
        ListNode mid = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            beforeMid = mid;
            mid = mid.next;
        }
        TreeNode node = new TreeNode(mid.val);
        node.right = buildTree(mid.next);
        beforeMid.next = null;
        node.left = buildTree(head);
        return node;
        
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return buildTree(head);
    }
}
