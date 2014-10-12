public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        
        if (!check(s1, s2))
            return false;
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s31 = s2.substring(s1.length() - i);
            String s32 = s2.substring(0, s1.length() - i);
            
            if (isScramble(s11, s21) && isScramble(s12, s22) ||
                isScramble(s11, s31) && isScramble(s12, s32))
                return true;
        }    
        return false;
    }
    
    private boolean check(String s1, String s2) {
        char[] a = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0)
                return false;
        }
        return true;
    }
}
