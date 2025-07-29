public class CoinChange {

    // Approach-1 -> Using greedy sorting method
    public static int coinChange(int[] coins, int amount) {

        // coins[] = {1,2,5,10,20,50,100,200,500,1000}

        // If amount is 0, then no need to do anything
        if (amount == 0)
            return 0;

        // Find the length
        int n = coins.length;

        // Initialize the count of coins
        int count = 0;

        // Iterate over the coins in descending order to minimize
        for (int i = n - 1; i >= 0; i--) {

            // Get current coin
            int coin = coins[i];

            if (coin > amount)
                continue;

            // There will be amount / coin number of coins used
            count += (amount / coin);

            // The remainder of the amount will be the new amount
            amount %= coin;

            // If the amount is 0, then we have found the solution
            if (amount == 0)
                break;
        }

        // Return count as the final answer
        return count;
    }
}
