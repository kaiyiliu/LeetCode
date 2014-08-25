/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode node = root;
        root.next = null;
        TreeLinkNode p1 = null;
        while (true) {
            p1 = null;
            // find the head of the next level
            while (p1 == null && node != null) {
                if (node.left != null)
                    p1 = node.left;
                else if (node.right != null)
                    p1 = node.right;
                else
                    node = node.next;
            }
            TreeLinkNode newNode = p1;      // the next node
            // exit when there is no head of the next level
            if (node == null)
                break;
            // prepare
            if (p1 == node.left) {
                if (node.right != null) {
                    p1.next = node.right;
                    p1 = p1.next;
                }
            }
            node = node.next;
            // connect everthing in the next level
            while (node != null) {
                if (node.left != null) {
                    p1.next = node.left;
                    p1 = p1.next;
                }
                if (node.right != null) {
                    p1.next = node.right;
                    p1 = p1.next;
                }
                node = node.next;
            }
            p1.next = null;
            node = newNode;
        }
    }
}
