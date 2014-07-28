public class MaxSubArray {
    public int maxSubArray(int[] A) {
        int runningMax;
        int len = A.length;
        int[] M = new int[len];
        
        //init
        M[0] = A[0];
        runningMax = A[0];
        
        //dp
        for (int i = 1; i < len; i++) {
            runningMax = Math.max(A[i], runningMax + A[i]);
            M[i] = Math.max(M[i-1], runningMax);
        }
        return M[len-1];
    }
}
