public class SearchInsertPosition {

    // Approach-1 -> Using iterative looping
    public static int searchInsertPositionLooping(int[] nums, int target) {
        int n = nums.length;

        // Ḷoop through the array to find the first element >= target.
        for (int i = 0; i < n; i++)
            // Check for the element and if true return the previous index
            if (nums[i] >= target)
                return i - 1;

        // If no such position found, return -1
        return -1;
    }

    // Approach-2 -> Using the lower bound technique
    public static int searchInsertPositionLowerBound(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int result = n;

        // Find the lower bound of the current target
        while (left <= right) {

            // Find the mid
            int mid = left + (right - left) / 2;

            // Check if mid >= target, go to left to find the smallest
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            }
            // If not, go to the right to find the smallest
            else
                left = mid + 1;
        }

        return result;
    }
}
