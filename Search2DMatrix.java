public class Search2DMatrix {
    public int bSearchRow(int[][] matrix, int target, int low, int high) {
        if (low > high)
            return low - 1;
        int mid = (high - low) / 2 + low;
        if (matrix[mid][0] < target)
            return bSearchRow(matrix, target, mid + 1, high);
        if (matrix[mid][0] > target)
            return bSearchRow(matrix, target, low, mid - 1);
        return mid;
    }
    
    public boolean bSearch(int[] row, int target, int low, int high) {
        if (low > high)
            return false;
        int mid = (high - low) / 2 + low;
        if (row[mid] < target)
            return bSearch(row, target, mid + 1, high);
        if (row[mid] > target)
            return bSearch(row, target, low, mid - 1);
        return true;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        int M = matrix.length;
        int N = matrix[0].length;
        int row = bSearchRow(matrix, target, 0, M - 1);
        if (row < 0)
            return false;
        return bSearch(matrix[row], target, 0, N - 1);
    }
}
