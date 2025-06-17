public class UpperBound {

    // Approach-1 -> Using the max value and binary search
    public static int upperBound(int[] nums, int x) {

        int n = nums.length;
        int upper = n;
        int low = 0, high = n - 1;

        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if mid is > x, search the left sorted
            if (nums[mid] > x) {
                upper = mid;
                high = mid - 1;
            }
            // If not, search the right sorted
            else
                low = mid + 1;
        }

        return upper;
    }
}
