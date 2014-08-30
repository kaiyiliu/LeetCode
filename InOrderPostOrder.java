/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InOrderPostOrder {
    private TreeNode helper(int lo1, int hi1, int[] inorder, int lo2, int hi2, int[] postorder) {
        if (lo1 > hi1)
            return null;
        int val = postorder[hi2];
        TreeNode node = new TreeNode(val);
        int i = lo1;
        for (; i <= hi1; i++)
            if (inorder[i] == val)
                break;
        node.left = helper(lo1, i - 1, inorder, lo2, lo2 + i - lo1 - 1, postorder);
        node.right = helper(i + 1, hi1, inorder, lo2 + i - lo1, hi2 - 1, postorder);
        return node;
        
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        TreeNode dummy = new TreeNode(0);
        dummy.right = helper(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
        return dummy.right;
    }
}
