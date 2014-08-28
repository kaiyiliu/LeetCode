public class LongestPalindromic {
    // be careful: do not overuse ++
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int len = s.length();
        Bag[] A = new Bag[len];
        A[0] = new Bag(0, 1);
        for (int n = 1; n < len; n++) {
            int posStart = n - A[n-1].length;
            if (isPalindrome(s, posStart - 1, n))
                A[n] = new Bag(posStart - 1, A[n-1].length + 2);
            else if (isPalindrome(s, posStart, n))
                A[n] = new Bag(posStart, A[n-1].length + 1);
            else
                A[n] = new Bag(A[n-1].start, A[n-1].length);
        }
        return s.substring(A[len-1].start, A[len-1].start + A[len-1].length);
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0)
            return false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                break;
            start++;
            end--;
        }
        if (start >= end)
            return true;
        return false;
    }
    
    private class Bag {
            private int start;
            private int length;
            
            Bag(int start, int length) {
                this.start = start;
                this.length = length;
            }
        }
    }
