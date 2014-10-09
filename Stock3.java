public class Stock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int len = prices.length;
        int[] left = new int[len];
        int min = prices[0];
        int max = prices[len-1];
        
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        
        int total = left[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            total = Math.max(total, left[i] + max - prices[i]);
        }
        
        return total;
    }
}
