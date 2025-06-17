public class PivotElement {

    // Approach-1 -> Using the linear scan
    public static int pivotElementLoop(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        // Linearly scan for the element where previous number is greater than current
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                pivot = i;
                break;
            }
        }

        return pivot;
    }

    // Approach-2 -> Using the smallest element concept
    public static int pivotElementSmallest(int[] nums) {
        int n = nums.length;
        int pivot = Integer.MAX_VALUE;
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            // Calculate the mid
            int mid = low + (high - low) / 2;

            // If the array is sorted but not rotated
            if (nums[low] <= nums[high]) {
                if (nums[low] < ans) {
                    ans = nums[low];
                    pivot = low;
                }
                break;
            }

            // Check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] < ans) {
                    ans = nums[low];
                    pivot = low;
                }
                // Go to the right side in unsorted part
                low = mid + 1;
            }
            // Check for right sorted
            else {
                if (nums[mid] < ans) {
                    ans = nums[mid];
                    pivot = mid;
                }
                // Go to the left side in unsorted part
                high = mid - 1;
            }
        }

        return pivot;
    }
}
