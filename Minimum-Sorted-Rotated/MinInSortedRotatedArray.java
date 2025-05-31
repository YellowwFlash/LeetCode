public class MinInSortedRotatedArray {

    // Approach-1 -> By eradication of halves using sorted search techniques
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;

        // Modified binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Array left sorted case
            if (nums[low] <= nums[mid]) {

                // Get the lower from sorted side
                min = Math.min(min, nums[low]);

                // Now going to the unsorted portion to check if there is a smaller element
                low = mid + 1;
            }

            // Array right sorted case
            else {

                // Since right half is sorted, the min element of right half is at mid
                min = Math.min(min, nums[mid]);

                // Taking care of the min element, going to unsorted part for a smaller element
                high = mid - 1;
            }

        }

        return min;
    }

}