public class MaxConsecutiveOnes {
    // Approach-1 -> Using the counting approch
    public static int maxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;

        // Traverse the numbers
        for (int number : nums)
            // When the number is not 1, just update max and reset the count
            if (number != 1) {
                max = Math.max(max, count);
                count = 0;
            }
            // When the number is 1, just increment the count
            else
                count++;

        // Final check if the whole array is of 1s only
        return Math.max(count, max);
    }
}
