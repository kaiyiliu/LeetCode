public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int result = 0;
        int i = 0;
        while (i <= s.length() - 1) {
            HashSet<Character> hs = new HashSet<Character>();
            int j = i;
            for (; j <= s.length() - 1; j++) {
                if (hs.contains(s.charAt(j)))
                    break;
                hs.add(s.charAt(j));
            }
            result = Math.max(result, hs.size());
            if (j >= s.length() - 1)
                break;
            while (s.charAt(i) != s.charAt(j))
                i++;
            i++;
        }
        return result;
    }
}
