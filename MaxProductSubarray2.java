public class MaxProductSubarray2 {
    // max_i: The maximum product with the ending integer at index i. If negative, max_i = 1
    // min_i: The minimum product with the ending integer at index i.
    // res:   The global maxium product.
    
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        
        int max_i = 1;
        int min_i = 1;
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            
            if (A[i] > 0) {
                max_i = max_i * A[i];
                min_i = min_i * A[i];
                res = Math.max(res, max_i);
            } else if (A[i] == 0) {
                max_i = 1;
                min_i = 1;
                res = Math.max(res, 0);
            } else {
                int oldMax_i = max_i;
                res = Math.max(res, min_i * A[i]);
                max_i = Math.max(1, min_i * A[i]);
                min_i = oldMax_i * A[i];
            }
        }
        return res;
    }
}
