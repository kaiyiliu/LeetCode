public class GenerateParentheses  {
    private void helper(StringBuilder sb, List<String> result, int leftRem, int rightRem) {
        if (leftRem == 0 && rightRem == 0) {
            result.add(sb.toString());
            return;
        }
        if (rightRem > leftRem) {
            sb.append(')');
            helper(sb, result, leftRem, rightRem - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (leftRem > 0) {
            sb.append('(');
            helper(sb, result, leftRem - 1, rightRem);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        if (n <= 0)
            return result;
        StringBuilder sb = new StringBuilder();
        helper(sb, result, n, n);
        return result;
    }
}
