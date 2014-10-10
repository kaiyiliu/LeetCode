/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Stack<TreeNode> st = new Stack<TreeNode>();
        boolean isRight = true;
        st.push(root);
        List<Integer> first = new LinkedList<Integer>();
        first.add(root.val);
        result.add(first);
        
        while (!st.isEmpty()) {
            Stack<TreeNode> temp = new Stack<TreeNode>();
            List<Integer> list = new LinkedList<Integer>();
            while (!st.isEmpty()) {
                TreeNode cur = st.pop();
                if (isRight) {
                    if (cur.right != null) {
                        temp.push(cur.right);
                        list.add(cur.right.val);
                    }
                    if (cur.left != null) {
                        temp.push(cur.left);
                        list.add(cur.left.val);
                    }
                    
                } else {
                    if (cur.left != null) {
                        temp.push(cur.left);
                        list.add(cur.left.val);
                    }
                    if (cur.right != null) {
                        temp.push(cur.right);
                        list.add(cur.right.val);
                    }
                }
            }
            if (!list.isEmpty())
                result.add(list);
            st = temp;
            temp = null;
            list = null;
            isRight = (isRight) ? false : true;
        }
        return result;
    }
}
