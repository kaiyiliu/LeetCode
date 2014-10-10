/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        int[] index = new int[1];
        TreeNode dummy = new TreeNode(0);
        
        dummy.right = helper(index, preorder, 0, inorder.length - 1, inorder);
        return dummy.right;
    }
    
    private TreeNode helper(int[] index, int[] preorder, int low, int high, int[] inorder) {
        if (low > high)
            return null;
        TreeNode root = new TreeNode(preorder[index[0]]);
        int mid = low;
        
        while (mid <= high && inorder[mid] != preorder[index[0]])
            mid++;
        
        index[0]++;
        root.left = helper(index, preorder, low, mid - 1, inorder);
        root.right = helper(index, preorder, mid + 1, high, inorder);
        return root;
    }
}
