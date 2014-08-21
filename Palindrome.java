public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int digit = (int) Math.log10(x) + 1;
        for (int n = 1; n <= digit / 2; n++) {
            int right = (int) (x % Math.pow(10, n) / Math.pow(10, n - 1));
            int left = (int) (x / Math.pow(10, digit - n) % 10);
            if (right != left)
                return false;
        }
        return true;
    }
}
