public class ReverseInteger {
    public int reverse(int x) {
    // notice the overflow issue
    
        if (x == 0)
            return x;
        int rev = 0;
        boolean isNeg = false;
        if (x < 0)
            isNeg = true;
        x = Math.abs(x);
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (isNeg) ? -rev : rev;
    }
}
