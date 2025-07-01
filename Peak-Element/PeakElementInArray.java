public class PeakElementInArray {

    // Approach-1 -> Using linear scan
    public static int findPeakElementLoop(int[] nums) {
        int n = nums.length;

        // Check if first element is peak
        if (n == 1 || nums[0] > nums[1])
            return nums[0];

        // Check if last element is peak
        if (nums[n - 1] > nums[n - 2])
            return nums[n - 1];

        // Loop the rest of the elements
        for (int i = 1; i < n - 1; i++) {

            // Check for the peak
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }

        return -1;
    }

    // Approach-2 -> Using modified binary search (due to elimination of halves)
    public static int findPeakElementBS(int[] nums) {
        int n = nums.length;

        // Check if first element is peak
        if (n == 1 || nums[0] > nums[1])
            return 0;

        // Check if last element is peak
        if (nums[n - 1] > nums[n - 2])
            return n-1;

        // Search in the shrinked space from 2nd-2nd last element
        int left = 1, right = n - 2;

        while (left <= right) {

            // Calculate the mid
            int mid = left + (right - left) / 2;

            // Check if mid is peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            // If the left side is bigger, peak will be in left part
            if (nums[mid - 1] > nums[mid])
                right = mid - 1; // Elimination of the right portion

            // If the right side is bigger, peak will be in right
            else 
                left = mid + 1; // Elimination of the left portion
        }

        return -1;
    }
}
