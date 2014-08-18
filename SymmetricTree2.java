/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.remove();
            TreeNode n2 = q2.remove();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null|| n1.val != n2.val)
                return false;
            q1.add(n1.left);
            q1.add(n1.right);
            q2.add(n2.right);
            q2.add(n2.left);
        }
        if (!q1.isEmpty() || !q2.isEmpty())
            return false;
        else
            return true;
    }
}
