public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> match = new HashMap<Character, Character>();
        match.put('(', ')');
        match.put('{', '}');
        match.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (match.containsKey(c)) {
                stack.push(c);
            } else if (match.containsValue(c)) {
                if (stack.isEmpty() || c != match.get(stack.pop()))
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
