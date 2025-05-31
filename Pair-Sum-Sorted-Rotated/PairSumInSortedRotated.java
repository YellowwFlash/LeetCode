public class PairSumInSortedRotated {

    // Approah-1 -> Using modified two pointers technique
    public static boolean findPairSum(int[] nums, int target) {
        int n = nums.length;

        // First find the pivot element of rotated array
        int pivot = findPivot(nums);

        // Make the left and right pointers to traverse
        int left = (pivot + 1) % n, right = pivot;

        while (left != right) {
            int sum = nums[left] + nums[right];
            // If the sum of both of those pointers is the sum
            if (sum == target)
                return true;

            // If the sum is less than that of target
            else if (sum < target)
                // Move the left pointer
                left = (left + 1) % n;

            // If the sum is greater than that of target
            else
                // Move the right pointer
                right = (right - 1 + n) % n;
        }

        return false;
    }

    private static int findPivot(int[] nums) {
        int n = nums.length, pivot = 0;

        for (int i = 0; i < n; i++)
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }

        return pivot;
    }
}
