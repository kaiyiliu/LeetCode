public class MinimumWindow {
    public String minWindow(String S, String T) {
        if (S == null || T == null || T.length() > S.length())
            return null;
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
        int dist = Integer.MAX_VALUE;
        int front = 0;
        int end = 0;
        int count = 0;
        while (front < S.length() && count != T.length()) {
            if (hm.containsKey(S.charAt(front))) {
                hm.put(S.charAt(front), hm.get(S.charAt(front) + 1));
                count++;
                if (count == 1)
                    end = front;
            }
            front++;
        }
        System.out.print(end);
        if (count < T.length())
            return "";
        p[0] = end;
        p[1] = --front;
        dist = front - end;
        while (end <= front && front < S.length()) {
            if (hm.get(S.charAt(end)) > 0) {
                hm.put(S.charAt(end), hm.get(S.charAt(end)) - 1);
                end++;
                while (end <= front && !hm.containsKey(S.charAt(end)))
                    end++;
                if (end > front)
                    break;
                if (front - end < dist) {
                    dist = front - end;
                    p[0] = end;
                    p[1] = front;
                }
            } else {
                front++;
                while (front < S.length() && !hm.containsKey(S.charAt(front)))
                    front++;
                if (front >= S.length())
                    break;
                hm.put(S.charAt(front), hm.get(S.charAt(front)) + 1);
            }
        }
        return S.substring(p[0], p[1] + 1);
    }
}
