/**
* Definition for binary tree
* public class TreeNode {
* int val;
* TreeNode left;
* TreeNode right;
* TreeNode(int x) { val = x; }
* }
*/
public class BSTInOrder {
LinkedList result = new LinkedList<Integer>();

public void traverse(TreeNode node) {
    if (node == null)
          return;
    traverse(node.left);
    result.add(node.val);
    traverse(node.right);    
}
public List<Integer> inorderTraversal(TreeNode root) {
    traverse(root);
    return result;
}
}
