/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeaf {
    public void search(TreeNode node, int[] sum, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append("" + node.val);
        if (node.left == null && node.right == null) {
            sum[0] += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        search(node.left, sum, sb);
        search(node.right, sum, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        StringBuilder sb = new StringBuilder();
        search(root, sum, sb);
        return sum[0];
    }
}
