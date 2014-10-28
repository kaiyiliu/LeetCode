public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2)
            return;
        int hi = matrix.length - 1;
        int lo = 0;

        while (lo < hi) {
            int[] temp = new int[hi - lo];
            for (int j = 0, i = lo; i < hi; i++) 
                temp[j++] = matrix[i][lo];
            
            for (int k = lo; k <= hi; k++) 
                matrix[k][lo] = matrix[hi][k];
        
            for (int k = lo + 1; k <= hi; k++)
                matrix[hi][k] = matrix[hi - k + lo][hi];
        
            for (int k = lo + 1; k < hi; k++)
                matrix[k][hi] = matrix[lo][k];
            
            for (int i = hi - lo - 1, j = lo + 1; j <= hi; j++)
                matrix[lo][j] = temp[i--];
                
            lo++;
            hi--;
        }
    }
}
