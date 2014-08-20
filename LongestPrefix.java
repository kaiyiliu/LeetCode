public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";
        if (strs[0] == null)
            return null;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < strs[0].length() && flag; i++) {
            char pattern = strs[0].charAt(i);
            sb.append(pattern);
            for (String e : strs) {
                if (e == null)
                    return null;
                if (i >= e.length() || e.charAt(i) != pattern) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag)
            return sb.toString();
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
