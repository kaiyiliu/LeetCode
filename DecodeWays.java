public class DecodeWays {
    private boolean isValid(char c1, char c2) {
        int n1 = Character.getNumericValue(c1);
        int n2 = Character.getNumericValue(c2);
        if (n2 == 0 || (n1 != 1 && n1 != 2))
            return false;
        if (n1 == 2 && n2 > 6)
            return false;
        return true;
    }
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        int[] A = new int[s.length() + 1];
        A[0] = 1;
        A[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0' && (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2'))
                return 0;
            if (isValid(s.charAt(i - 2), s.charAt(i - 1)))
                A[i] = A[i - 1] + A[i - 2];
            else if (s.charAt(i - 1) != '0')
                A[i] = A[i - 1];
            else
                A[i] = A[i - 2];
        }
        return A[s.length()];
    }
}
