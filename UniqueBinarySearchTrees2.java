/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class UniqueBinarySearchTrees2 {
    // return a list!
    
    private List<TreeNode> helper(int low, int high) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (low > high) {
            list.add(null);
            return list;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftList = helper(low, i - 1);
            List<TreeNode> rightList = helper(i + 1, high);
            for (TreeNode leftNode : leftList)
                for (TreeNode rightNode : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
        }
        return list;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
}
