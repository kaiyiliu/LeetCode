public class StrStr {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return null;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            int ii = i;
            while (j < needle.length()) {
                if (haystack.charAt(ii) != needle.charAt(j))
                    break;
                ii++;
                j++;
            }
            if (j == needle.length())
                return haystack.substring(i);
        }
        return null;
    }
}
