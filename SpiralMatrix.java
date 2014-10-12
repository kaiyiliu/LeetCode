public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0)
            return result;
        
        helper(result, 0, matrix.length - 1, 0, matrix[0].length - 1, matrix);
        return result;
    }
    
    private void helper(List<Integer> result, int r1, int r2, int c1, int c2, int[][] matrix) {
        if (r1 > r2 || c1 > c2)
            return;
        int i;
        int j;
        for (j = c1; j <= c2; j++)
            result.add(matrix[r1][j]);
        for (i = r1 + 1; i <= r2; i++)
            result.add(matrix[i][c2]);
        if (r1 != r2)
            for (j = c2 - 1; j >= c1; j--)
                result.add(matrix[r2][j]);
        if (c1 != c2)
            for (i = r2 - 1; i >= r1 + 1; i--)
                result.add(matrix[i][c1]);
        helper(result, r1 + 1, r2 - 1, c1 + 1, c2 - 1, matrix);
    }
}
