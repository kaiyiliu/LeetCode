/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class NextRightPointer12 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> path = new Stack<TreeNode>();
        Stack<Integer> left = new Stack<Integer>();
        path.push(root);
        left.push(sum - root.val);
        // DFS
        while (!path.isEmpty()) {
            TreeNode node = path.pop();
            int value = left.pop();
            if (node.left == null && node.right == null && value == 0) {
                return true;
            }
            if (node.right != null) {
                path.push(node.right);
                left.push(value - node.right.val);
            }
            if (node.left != null) {
                path.push(node.left);
                left.push(value - node.left.val);
            }
        }
        return false;
    }
}
