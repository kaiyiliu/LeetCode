public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int result = 0;
        int left = 0;
        HashSet<Character> hs = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                result = Math.max(result, hs.size());
                while (s.charAt(left) != s.charAt(i)) {
                    hs.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                hs.add(s.charAt(i));
            }
            result = Math.max(result, hs.size());
        }
        return result;
    }
}
