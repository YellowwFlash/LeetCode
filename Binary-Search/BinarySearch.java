public class BinarySearch {

    // Approach-1 -> Iterative approach (most preferred)
    public static int binarySearchIterative(int[] nums, int target) {

        // Two pointers for the window
        int left = 0, right = nums.length - 1;

        // Iterate the array
        while (left <= right) {

            // Calculate the mid
            int mid = left + (right - left) / 2;

            // Check if the mid is current element
            if (nums[mid] == target)
                return mid;

            // If mid is smaller than target, element is at right side of array
            else if (nums[mid] < target)
                left = mid + 1;

            // If mid is larger than target, element is at left side of array
            else
                right = mid - 1;
        }

        // If no target found, return -1
        return -1;
    }

    // Approach-2 -> Recursive approach
    public static int binarySearchRecursive(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int low, int high) {
        // Base case
        if (low > high)
            return -1; // If not target found, return -1

        // Calculate the mid
        int mid = low + (high - low) / 2;

        // Check if mid is target
        if (nums[mid] == target)
            return mid;

        else if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, high);

        else
            return binarySearch(nums, target, low, mid - 1);
    }
}
