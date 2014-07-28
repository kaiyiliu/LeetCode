public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] sum = new int[m][n];
        int i = 0;
        int j = 0;
        
        //init
        for (i = 0 ; i < m; i++)
            sum[i][0] = 1;
        for (j = 0 ; j < n; j++)
            sum[0][j] = 1;
            
        //dp
        for (i = 1; i < m; i++)
            for (j =1 ; j < n; j++)
                sum[i][j] = sum[i-1][j] + sum[i][j-1];
        return sum[m-1][n-1];
    }
}
