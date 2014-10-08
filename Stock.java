public class Stock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int low = prices[0];
        int max = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low)
                low = prices[i];
            if (prices[i] - low > max)
                max = prices[i] - low;
        }
        
        return max;
    }
}
