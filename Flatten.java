/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null)
            return node;
        
        TreeNode leftEnd = helper(node.left);
        TreeNode rightEnd = helper(node.right);
    
        if (leftEnd != null) {
            TreeNode right = node.right;
            node.right = node.left;
            leftEnd.right = right;
            node.left = null;
        }
        
        if (rightEnd == null)
            rightEnd = leftEnd;
            
        return rightEnd;
    }
}
