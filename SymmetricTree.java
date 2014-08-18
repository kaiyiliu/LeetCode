/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        else if (leftNode == null || rightNode == null)
            return false;
        return (leftNode.val == rightNode.val) && isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);  
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
}
