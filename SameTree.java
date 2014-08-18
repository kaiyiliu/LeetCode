/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public void toList(TreeNode root, TreeNode[] list) {
        if (root == null) {
            list[0].right = new TreeNode(Integer.MIN_VALUE);
            list[0] = list[0].right;
            return;
        }
        if (root.left == null && root.right == null) {
            list[0].right = new TreeNode(root.val);
            list[0] = list[0].right;
            return;
        }
        list[0].right = new TreeNode(root.val);
        list[0] = list[0].right;
        toList(root.left, list);
        toList(root.right, list);
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        TreeNode qList = new TreeNode(0);
        TreeNode pList = new TreeNode(0);
        TreeNode[] qPointer = {qList};
        TreeNode[] pPointer = {pList};
        toList(p, pPointer);
        toList(q, qPointer);
        qList = qList.right;
        pList = pList.right;
        while (qList != null && pList != null) {
            if(qList.val != pList.val)
                return false;
            qList = qList.right;
            pList = pList.right;
        }
        if (qList != null || pList != null)
            return false;
        else
            return true;
    }
}
