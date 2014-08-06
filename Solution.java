/**
* Definition for binary tree
* public class TreeNode {
* int val;
* TreeNode left;
* TreeNode right;
* TreeNode(int x) { val = x; }
* }
*/
public class Solution {
     public LinkedList<Integer> list = new LinkedList<Integer>();
     public int result = 0;
     
     public void rmTrav(TreeNode node) {
          rmTraverse(node.right);
          list.add(node.val);  
     }

     public void mrTrav(TreeNode node) {
          list.add(node.val);
          mrTrav(node.right);
    }
    
    public int getMax(TreeNode node) {
          if (node == null)
            return 0;
          if (node.right == null)
            return node.val;
          else
            return getMax(node.right);
    }
    
    public void maxPath() {
        int sum = 0;
                 for (int e : list) {
                      sum += e;
                      if (sum > result)
                         result = sum;
                 }
    }
    
     public int maxPathSum(TreeNode root) {
           if (root == null)
              return 0;
          rmTrav(node.right);
          if (getMax(root.left) <= 0) {
              maxPath();
          } else {
             mrTrav(node.left);
             maxPath();
          }
          return result;
     }
}
