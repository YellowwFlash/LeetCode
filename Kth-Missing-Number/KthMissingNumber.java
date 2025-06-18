public class KthMissingNumber {

    // Approach-1 -> Using the loop
    public static int findKthPositiveLoop(int[] nums, int k) {

        for (int num : nums)

            // Check if the current number is less than k, then increase k else break
            if (num < k)
                k++;
            else
                break;

        return k;
    }

    // Approach-2 -> Using binary search
    public static int findKthPositiveBinarySearch(int[] nums, int k) {

        // Define the space
        int left = 0, right = nums.length - 1;

        // Binary search
        while (left <= right) {

            // Find the mid
            int mid = left + (right - left) / 2;

            // Check for mid and find the missing nums
            if (k > nums[mid] - (mid + 1))
                // Go to the right half
                left = mid + 1;

            // If not, go to the left half
            else
                right = mid - 1;
        }

        return left + k;
    }
}
