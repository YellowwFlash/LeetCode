public class FloorCeil {

    // Approach-1 -> Using the advanced lower and upper bound algorithm
    public static int[] floorCeil(int[] nums, int target) {

        int floor = findFloor(nums, target);
        int ceil = findCeil(nums, target);

        return new int[] { floor, ceil };
    }

    private static int findCeil(int[] nums, int target) {
        // Finding the lower bound of target will give the ceil value
        int n = nums.length;
        int low = 0, high = n - 1;
        int ceil = n;

        while (low <= high) {
            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if the mid >= target, go to left to find smaller one
            if (nums[mid] >= target) {
                ceil = nums[mid];
                high = mid - 1;
            }
            // If not, go to the right to find one
            else
                low = mid + 1;
        }

        return ceil;
    }

    private static int findFloor(int[] nums, int target) {
        // Finding the upper bound of target with modification will give the floor value
        int n = nums.length;
        int low = 0, high = n - 1;
        int floor = n;

        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if the mid <= target (here smaller value is required)
            if (nums[mid] <= target) {
                floor = nums[mid];
                // Here, since smaller value is required, going to right will give it
                low = mid + 1;
            }
            // If not, go to the left portion
            else
                high = mid - 1;
        }

        return floor;
    }
}
