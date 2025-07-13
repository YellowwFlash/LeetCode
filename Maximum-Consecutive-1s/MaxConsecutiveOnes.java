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

    // Approach-2 -> Using the sliding window approach(when flipping is allowed)
    public static int maxConsecutiveOnesII(int[] nums, int k) {

        // Find length
        int n = nums.length;

        // Define left and right
        int left = 0, right = 0;

        // Define maximum frequency and length
        int zeros = 0, maxLength = 0;

        // Loop through the nums for finding the maximum window
        while (right < n) {

            if (nums[right] == 0)
                zeros++;

            while (zeros > k) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }

            // Update the maxLength
            maxLength = Math.max(maxLength, right - left + 1);

            // Increase the right pointer
            right++;
        }

        // Return the max length as the final result
        return maxLength;
    }
}
