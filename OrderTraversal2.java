/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class OrderTraversal2 {
    // use queue to do BFS and a stack to store the node along the BFS.
    // After each level BFS, insert a dummy node to deliminate the level
    
    // You can use ArrayList to add in the front
    
    private void search(LinkedList<TreeNode> q, Stack<Integer> s) {
        while (q.size() > 1) {
            TreeNode node = q.poll();
            s.push(node.val);
            if (node.val == Integer.MIN_VALUE) {
                q.add(new TreeNode(Integer.MIN_VALUE));
                continue;
            }
            if (node.left == null && node.right == null)    // leaf node
                continue;
            if (node.right != null) {
                q.add(node.right);
               //s.push(node.right.val);
            }
            if (node.left != null) {
                q.add(node.left);
                //s.push(node.left.val);
            }
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new LinkedList<List<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        Stack<Integer> s = new Stack<Integer>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        q.add(root);
        q.add(new TreeNode(Integer.MIN_VALUE));
        search(q, s);
        List<Integer> list = new LinkedList<Integer>();
        while (!s.isEmpty()) {
            int val = s.pop();
            if (val == Integer.MIN_VALUE) {
                if (!list.isEmpty())
                    result.add(list);
                list = new LinkedList<Integer>();
                continue;
            }
            list.add(val);
        }
        if (!list.isEmpty())
            result.add(list);
        return result;
    }
}
