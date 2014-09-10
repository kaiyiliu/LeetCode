public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s == null)
            return null;
        s = s.trim();
        if (s.length() == 0)
            return s;
        Stack<String> st = new Stack<String>();
        int i = 0;
        while (i < s.length()) {
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            st.push(sb.toString());
            if (i >= s.length())
                break;
            st.push(" ");
            while (i < s.length() && s.charAt(i) == ' ')
                i++;
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty())
            result.append(st.pop());
        return result.toString();
    }
}
