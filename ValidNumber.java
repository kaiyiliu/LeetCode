public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();
        if (s.length() == 0)
            return false;
        int i = 0;
        boolean exp = false;
        boolean dot = false;
        boolean num = false;
        if (s.charAt(i) == '+' || s.charAt(i) == '-')
            i++;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = true;
            else if (c == '.') {
                if (dot || exp)
                    return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || !num)
                    return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i-1) != 'e')
                    return false;
            } else
                return false;
        }
        return num;
    }
}
