public class LastOccurrence {

    // Approach-1 -> Using the upper bound algorithm
    public static int lastOccurance(int nums[], int x) {
        int result = -1;
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if the mid == x, if it is go to right
            if (nums[mid] == x) {
                result = mid;
                low = mid + 1;
            } else if (nums[mid] > x) {
                // Move left
                high = mid - 1;
            } else {
                // Move right
                low = mid + 1;
            }
        }

        return result;
    }

    // Approach-2 -> For finding the First occurrence
    public static int firstOccurance(int nums[], int x) {
        int result = -1;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == x) {
                result = mid;
                high = mid - 1;
            } else if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
