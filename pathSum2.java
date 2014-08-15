/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class pathSum2 {
 //   public List<List<Integer>> result = new LinkedList<List<Integer>>();
    
    public void search(LinkedList<List<Integer>> result, LinkedList<Integer> list, TreeNode root, int remained) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (remained - root.val == 0) {
                list.add(root.val);
                result.add((LinkedList) list.clone());
                list.removeLast();
            }
        } else {
            list.add(root.val);
            search(result, list, root.left, remained - root.val);
            search(result, list, root.right, remained - root.val);
            list.removeLast();
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        search(result, new LinkedList<Integer>(), root, sum);
        return result;
    }
}
