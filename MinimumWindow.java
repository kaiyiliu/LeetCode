public class MinimumWindow {
    public String minWindow(String S, String T) {
        if (S == null || T == null || T.length() > S.length())
            return "";
        if (T.length() == 0)
            return "";
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (hm.containsKey(T.charAt(i)))
                hm.put(T.charAt(i), hm.get(T.charAt(i)) - 1);
            else
                hm.put(T.charAt(i), -1);
        }
        int[] p = new int[2];
        int front = 0;
        int end = 0;
        int count = 0;
        // front will be pointed at the front of the window
        while (front < S.length()) {
            if (hm.containsKey(S.charAt(front))) {
                hm.put(S.charAt(front), hm.get(S.charAt(front)) + 1);
                if (hm.get(S.charAt(front)) <= 0) {
                    count++;
                    if (count == 1)
                        end = front;
                    if (count == T.length())
                        break;
                }
            }
            front++;
        }
        if (count != T.length())
            return "";
        p[0] = end;
        p[1] = front;
        int dist = front - end;
        while (true) {
            while (hm.get(S.charAt(end)) > 0) {
                hm.put(S.charAt(end), hm.get(S.charAt(end)) - 1);
                end++;
                while (end <= front && !hm.containsKey(S.charAt(end)))
                    end++;
                if (front - end < dist) {
                    dist = front - end;
                    p[0] = end;
                    p[1] = front;
                }
            }
            front++;
            while (front < S.length() && !hm.containsKey(S.charAt(front)))
                front++;
            if (front >= S.length())
                break;
            hm.put(S.charAt(front), hm.get(S.charAt(front)) + 1);
             
        }
        return S.substring(p[0], p[1] + 1);
    }
}
