public class WordBreak {
    // think about when should we calculate and avoid redudent check
    
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return true;
        if (dict == null)
            return false;
        boolean[] A = new boolean[s.length() + 1];
        A[0] = true;
        
        for (int i = 0; i <= s.length(); i++) {
            if (!A[i])
                continue;
            for (String e : dict) {
                int end = i + e.length();
                if (end > s.length() || A[end] == true)
                    continue;
                if (s.substring(i, end).equals(e))
                    A[end] = true;
            }
        }
        return A[s.length()];
    }
}
