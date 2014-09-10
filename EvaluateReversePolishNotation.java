public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.matches("-?\\d+"))
                st.push(Integer.parseInt(s));
            else {
                if (st.size() < 2)
                    return 0;
                int b = st.pop();
                int a = st.pop();
                if (s.equals("+"))
                    st.push(a + b);
                else if (s.equals("-"))
                    st.push(a - b);
                else if (s.equals("*"))
                    st.push(a * b);
                else if (s.equals("/"))
                    if (b == 0)
                        return Integer.MAX_VALUE;
                    else
                        st.push(a / b);
                else
                    return 0;
            }
        }
        if (st.size() != 1)
            return 0;
        return st.pop();
    }
}
