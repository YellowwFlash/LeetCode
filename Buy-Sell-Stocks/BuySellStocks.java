public class BuySellStocks {
    // Approach-1 -> Finding the least element in running array traversal 
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;

        // Traverse the array
        for (int i = 1; i < n; i++) {
            int currentPrice = prices[i] - minPrice;

            //Update the max profit if current profit is greater than actual 
            maxProfit = Math.max(maxProfit, currentPrice);

            // Update the min price if current price is less than actual
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }

}
