public class LargestRectangle1 {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length < 1)
            return 0;
            
        // Build RMQ Tree
        int h = (int) Math.ceil(Math.log(height.length) / Math.log(2));
        int size = 2 * (int) Math.pow(2, h) - 1;
        int[] rmq = new int[size];
        buildRMQ(0, rmq, 0, height.length - 1, height);
        
        return helper(0, height.length - 1, height, rmq);
    }
    
    private int getMinIndex(int i, int j, int[] height) {
        if (i == -1)
            return j;
        if (j == -1)
            return i;
        return (height[i] < height[j]) ? i : j;
    }
    
    private int helper(int low, int high, int[] height, int[] rmq) {
        if (low > high)
            return 0;
        if (low == high)
            return height[low];
        
        // find out the index min-height hist
        int bottom = findBottom(0, rmq, 0, height.length - 1, low, high, height);
        
        int max = Math.max(helper(low, bottom - 1, height, rmq), helper(bottom + 1, high, height, rmq));
        return Math.max(max, bottom * (high - low + 1));
    }
    
    private int findBottom(int index, int[] rmq, int curLow, int curHigh, int low, int high, int[] height) {
        if (low <= curLow && high >= curHigh)
            return rmq[index];
        if (low > curHigh || high < curLow)
            return -1;
        
        int curMid = curLow + (curHigh - curLow) / 2;
        int left = findBottom(2 * index + 1, rmq, curLow, curMid, low, high, height);
        int right = findBottom(2 * index + 2, rmq, curMid + 1, curHigh, low, high, height);
        return getMinIndex(left, right, height);
    }
    
    private int buildRMQ(int index, int[] rmq, int low, int high, int[] height) {
        if (low == high) {
            rmq[index] = low;
            return low;
        }
        int mid = low + (high - low) / 2;
        int left = buildRMQ(2 * index + 1, rmq, low, mid, height);
        int right = buildRMQ(2 * index + 2, rmq, mid + 1, high, height);
        rmq[index] = getMinIndex(left, right, height);
        
        return rmq[index];
    }
}
