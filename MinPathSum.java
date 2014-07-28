public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] S = new int S[m][n];
        
        //init
        S[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            S[i][0] = S[i-1][0] + grid[i][0];   
        for (int j = 1; j < n; j++)
            S[0][j] = S[0][j-1] + grid[0][j];
            
        //dp
        for (int i = 1; i < m; i++)
            for (int j = 1; j< n; j++) {
                S[i][j] = Math.min(S[i-1][j], S[i][j-1]) + grid[i][j];
            }
        return S[m-1][n-1];
    }
    
}
