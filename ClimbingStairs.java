public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 0)
            return 0;
        int[] A = new int[n + 1];
        A[0] = 1;
        A[1] = 1;
        for (int i = 2; i <= n; i++)
            A[i] = A[i - 2] + A[i - 1];
        return A[n];
    }
}
