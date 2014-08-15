/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class NextRightPointers1 {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null)
            return;
        TreeLinkNode node = root;
        while (node.next != null) {
            node.left.next = node.right;
            node.right.next = node.next.left;
            node = node.next;
        }
        node.left.next = node.right;
        node.right.next = null;
        connect(root.left);
    }
}
