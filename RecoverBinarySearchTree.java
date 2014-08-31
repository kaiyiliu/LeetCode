/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBinarySearchTree {
    private void search(TreeNode node, TreeNode[] list) {
        if (node == null)
            return;
        search(node.left, list);
        if (list[1] == null && node.val < list[0].val)
            list[1] = list[0];
        if (list[1] != null && node.val < list[0].val)
            list[2] = node;
        list[0] = node;
        search(node.right, list);
    }
    
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode[] list = new TreeNode[3];
        list[0] = new TreeNode(Integer.MIN_VALUE);
        search(root, list);
        if (list[2] == null)
            return;
        int temp = list[1].val;
        list[1].val = list[2].val;
        list[2].val = temp;
    }
}
