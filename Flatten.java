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
    public TreeNode getFlat(TreeNode root) {
        if (root == null)
            return null;;
        TreeNode lRoot = getFlat(root.left);
        TreeNode rRoot = getFlat(root.right);
        if (lRoot == null) {
            root.right = rRoot;
        } else {
            root.right = lRoot;
            while (lRoot.right != null)
                lRoot = lRoot.right;
            lRoot.right = rRoot;
        }
        root.left = null;
        return root;
    }
    
    public void flatten(TreeNode root) {
        root = getFlat(root);
    }
}
