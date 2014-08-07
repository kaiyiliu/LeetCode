/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class sortedArrayToBST {
    public TreeNode buildTree(int l, int r, int[] num) {
        if (l > r)
            return null;
        int mid = (r - l) / 2 + l;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(l, mid - 1, num);
        node.right = buildTree(mid + 1, r, num);
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
       if (num == null)
            return null;
       else
            return buildTree(0, num.length - 1, num);
    }
}
