public class NQueens2 {
    public int totalNQueens(int n) {
        if (n < 1)
            return 0;
        int[] row = new int[n];
        return helper(0, row, n);
    }
    
    private int helper(int i, int[] row, int n) {
        if (i == n)
            return 1;
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(row, i, j)) {
                row[i] = j;
                count += helper(i + 1, row, n);
            }
        }
        return count;
    }
    
    private boolean isValid(int[] row, int i, int j) {
        for (int k = 0; k < i; k++)
            if (row[k] == j || Math.abs(i - k) == Math.abs(j - row[k]))
                return false;
        return true;
    }
}
