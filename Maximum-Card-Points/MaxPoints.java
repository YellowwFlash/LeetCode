public class MaxPoints {

    // Approach-1 -> Using sliding window
    public static int maxCardPoints(int[] cards, int k) {

        // Define left sum and right sum and max sum
        int left = 0, right = 0, sum = 0, index = cards.length - 1;

        // Sum up for the first k elements
        for (int i = 0; i < k; i++)
            left += cards[i];

        // Since right sum is 0, sum would be left
        sum = left;

        // Start add the right sum
        for (int i = k - 1; i >= 0; i--) {

            // Subtract the last element from left
            left -= cards[i];
            // Add the index element to right
            right += cards[index--];

            // Find the max of both
            sum = Math.max(sum, left + right);
        }

        // Return sum as the maximum points
        return sum;
    }
}
