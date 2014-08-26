public class LongestValidParen {
    // better solution
    // be careful when you should clear the running count
    // continuous substring, three senario:
    // "())(())", "(()((()))", "()()()()"
    
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i + 1);
            else if (stack.isEmpty() || stack.peek() < 0)   // c == ')'
                stack.push(-i - 1);
            else {
                stack.pop();
                if (stack.isEmpty())
                    count = i + 1;
                else
                    count = i + 1 - Math.abs(stack.peek());
            }
            result = Math.max(count, result);
        }
        return result;    
    }
}
