public class LowerBound {

    // Approach-1 -> Using the mininum and binary search
    public static int lowerBound(int[] nums, int x) {

        int n = nums.length;
        int lower = n;
        int low = 0, high = n - 1;

        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if the mid is >= x
            if (nums[mid] >= x) {
                // To find the smallest, left half should be explored
                lower = mid;
                high = mid - 1;
            }
            // If not move to the right half
            else {
                low = mid + 1;
            }
        }

        return lower;
    }
}
