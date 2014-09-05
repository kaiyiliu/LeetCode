public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        int result = 0;
        for (int e : num)
            hs.add(e);
        for (int e : num) {
            if (hs.contains(e)) {
                int count = 1;
                int left = e - 1;
                int right = e + 1;
                while (hs.contains(left)) {
                    count++;
                    hs.remove(left);
                    left--;
                }
                while (hs.contains(right)) {
                    count++;
                    hs.remove(right);
                    right++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
