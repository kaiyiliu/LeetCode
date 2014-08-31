public class AddBinary {
    // notice char convert to int
    
    public String addBinary(String a, String b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int value = carry + a.charAt(i--) - '0' + b.charAt(j--) - '0';
            carry = value / 2;
            sb.append("" + value % 2);
        }
        while(i >= 0) {
            if (carry == 0) {
                sb.reverse();
                return a.substring(0, i + 1) + sb.toString();
            } else {
                int value = carry + a.charAt(i--) - '0';
                carry = value / 2;
                sb.append("" + value % 2);
            }
        }
        while(j >= 0) {
            if (carry == 0) {
                sb.reverse();
                return b.substring(0, j + 1) + sb.toString();
            } else {
                int value = carry + b.charAt(j--) - '0';
                carry = value / 2;
                sb.append("" + value % 2);
            }
        }
        if (carry != 0)
            sb.append("1");
        return sb.reverse().toString();
    }
}
