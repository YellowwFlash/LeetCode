public class CountOccurrences {

    // Approach-1 -> Using linear iteration
    public static int countOccurrencesLinear(int[] nums, int target) {
        int count = 0;

        // Do a linear scan
        for (int num : nums)
            if (num == target)
                count++;

        return count;
    }

    // Approach-2 -> Using the first and last occurence
    public static int countOccurrencesBinary(int[] nums, int target) {
        int lower = findLower(nums, target);
        int upper = findUpper(nums, target);

        return upper - lower;
    }

    private static int findLower(int[] nums, int target) {
        int n = nums.length;
        int lower = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if mid >= target
            if (nums[mid] >= target) {
                lower = mid;
                // Go to left to find the smallest
                high = mid - 1;
            }
            // If not, go to the right
            else
                low = mid + 1;
        }

        return lower;
    }

    private static int findUpper(int[] nums, int target) {
        int n = nums.length;
        int upper = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if mid > target
            if (nums[mid] > target) {
                upper = mid;
                // Go to left to find the smallest
                high = mid - 1;
            }
            // If not, go to the right
            else
                low = mid + 1;
        }

        return upper;
    }
}
