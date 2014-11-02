public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        boolean[][] A = new boolean[len1 + 1][len2 + 1];
        A[0][0] = true;
        for (int j = 1; j <= len2; j++)
            A[0][j] = A[0][j - 1] && s2.charAt(j - 1) ==  s3.charAt(j - 1);
        for (int i = 1; i <= len1; i++)
            A[i][0] = A[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                A[i][j] = (A[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                          || (A[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        return A[len1][len2];
    }
}
