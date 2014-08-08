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
public class sortedListToBST2 {
    public ListNode itr; 
    public TreeNode buildTree(int l, int r) {
        if (l > r)
            return null;
        int m = (r - l) / 2 + l;
        TreeNode lnode = buildTree(l, m - 1);
        TreeNode node = new TreeNode(itr.val);
        itr = itr.next;
        node.left = lnode;
        node.right = buildTree(m + 1, r);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        this.itr = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return buildTree(1, len);
    }
}
