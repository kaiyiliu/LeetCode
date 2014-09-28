public class MaxProductSubarray {
    // max:         record the current max product
    // maxEnding:   record the product from the closest non-zero Integer up to current Integer
    // maxFront:    record the product from the closest non-zero Integer to the next negative Integer
    
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return 0;
            
        // Initialization
        int max = A[0];
        int maxEnding = 0;
        int maxFront = 1;
        boolean isFirstNeg = false;
        
        for (int e : A) {
            if (e == 0) {
                maxEnding = 0;
                maxFront = 1;
                isFirstNeg = false;
                if (max < 0)
                    max = 0;
                continue;
            }
            
            if (maxEnding == 0)
                maxEnding = e;
            else
                maxEnding *= e;
                
            if (e < 0 && !isFirstNeg) {
                maxFront = maxEnding;
                isFirstNeg = true;
                continue;
            }
                
            if (maxEnding > 0)
                max = Math.max(max, maxEnding);
            else if (maxEnding < 0)
                max = Math.max(max, maxEnding / maxFront);
        }
        return max;
    }
}
