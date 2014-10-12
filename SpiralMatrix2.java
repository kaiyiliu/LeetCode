public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n < 1)
            return new int[0][0];
        int[][] result = new int[n][n];
        int num = 1;
        int k = 0;
        
        while (num <= n * n) {
            int i;
            for (i = k; i < n - k; i++)
                result[k][i] = num++;
            for (i = k + 1; i < n - k; i++)
                result[i][n-k-1] = num++;
            for (i = n - k - 2; i >= k; i--)
                result[n-k-1][i] = num++;
            for (i = n - k - 2; i >= k + 1; i--)
                result[i][k] = num++;
            k++;
        }
        
        return result;
    }
}
