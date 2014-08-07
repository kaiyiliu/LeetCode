/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxPathSumBT {
    public int result = Integer.MIN_VALUE;
    
    public int getMax(TreeNode node) {
        if (node == null)
            return 0;
        int leftMax = getMax(node.left);
        int rightMax = getMax(node.right);
        int onewayMax = Math.max(Math.max(leftMax + node.val, rightMax + node.val), node.val);
        int archMax = leftMax + rightMax + node.val;
        result = Math.max(result, Math.max(onewayMax, archMax));
        return onewayMax;
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null)
              return 0;
          getMax(root);
          return result;
    }
}
