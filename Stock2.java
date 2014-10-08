public class Stock2 {
    // Do not forget the extreme cases and final sum-up
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int low = prices[0];
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                total += prices[i-1] - low;
                while (i + 1 < prices.length && prices[i+1] <= prices[i])
                    i++;
                low = prices[i];
            }
        }
        // last sum-up
        total += prices[prices.length - 1] - low;
        return total;
    }
}
