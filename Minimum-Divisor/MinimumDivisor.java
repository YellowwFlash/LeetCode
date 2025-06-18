public class MinimumDivisor {

    // Approach-1 -> Using linear scanning
    public static int minDivisor(int nums[], int threshold) {

        // Find max
        int max = findMax(nums);

        for (int i = 1; i <= max; i++)
            if (isValidDivisor(nums, threshold, i))
                return i;

        return -1;
    }

    // Approach-2 -> Using binary search
    public static int minDivisorBS(int nums[], int threshold) {
        int divisor = -1;

        // Create the bounds
        int low = 1, high = findMax(nums);

        // Binary search
        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check for validity of mid
            if (isValidDivisor(nums, threshold, mid)) {
                // Add mid for current answer
                divisor = mid;
                // Move to the right half for smaller value
                high = mid - 1;
            }

            // If not, go to the right half
            else
                low = mid + 1;
        }

        return divisor;
    }

    private static boolean isValidDivisor(int[] nums, int threshold, int current) {

        int total = 0;

        // Travese to find the validity
        for (int num : nums) {

            // Add the current division to the total
            // total += Math.ceil((double) num / current);

            total += (num + current - 1) / current; // Always gives the ceil value

            // Check for overflow(optimization)
            if (total > threshold)
                return false;
        }

        return total <= threshold;
    }

    private static int findMax(int[] nums) {
        int max = nums[0];

        for (int num : nums)
            max = Math.max(max, num);

        return max;
    }
}
