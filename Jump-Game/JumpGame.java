public class JumpGame {

    // Approach-1 -> Greedy approach of max index tracking
    public boolean canJump(int[] nums) {

        // Find the length
        int n = nums.length;

        // Initialize the max index
        int maxIndex = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {

            // Check if the current index is greater than the max index
            if (i > maxIndex) {
                return false;
            }

            // Update the max index
            maxIndex = Math.max(maxIndex, i + nums[i]);

            // If the max index crossed the last index, return true
            if (maxIndex >= n - 1) {
                return true;
            }
        }

        // Return false
        return false;
    }

    // Variation-2 -> Finding the min jumps to reach the guranteed end
    public static int minJumps(int[] nums) {

        // Find the length
        int n = nums.length;

        // Define min and max for keeping track of the ranges
        int min = 0, max = 0;

        // Initialize the jumps
        int jumps = 0;

        // Iterate through the array
        while (max < n - 1) {

            int farthest = 0;
            // Find the new ending point of new range
            for (int i = min; i <= max; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Update the min and max
            min = max + 1;
            max = farthest;
            jumps++;
        }

        // Return jumps as the final answer
        return jumps;
    }
}
