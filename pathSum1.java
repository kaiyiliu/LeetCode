/**
* Definition for binary tree
* public class TreeNode {
* int val;
* TreeNode left;
* TreeNode right;
* TreeNode(int x) { val = x; }
* }
*/
public class pathSum1 {
public int search(TreeNode root, int remained) {
    if (root == null)
        return 0;
    if (root.left == null && root.right == null) {
        if ((remained - root.val) == 0)
            return Integer.MIN_VALUE;
        else
            return remained;
    }
    if (search(root.left, remained - root.val) == Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
    if (search(root.right, remained - root.val) == Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
    return remained;
}

public boolean hasPathSum(TreeNode root, int sum) {
if (root == null)
return false;
if (search(root, sum) == Integer.MIN_VALUE)
return true;
else
return false;
}
}
