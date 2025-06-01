public class ContainerWithMostWater {

    // Approach-1 -> Using two loops
    public static int maxWaterLoops(int[] height) {
        int maxWater = 0, n = height.length;

        // External loop for the first value
        for (int i = 0; i < n - 1; i++) {
            // Internal loop for the second value
            for (int j = i + 1; j < n; j++) {
                // Calculate the area of water between the two bars
                int water = Math.min(height[i], height[j]) * (j - i);
                // Update the maximum water area
                maxWater = Math.max(maxWater, water);
            }
        }

        return maxWater;
    }

    // Approach-2 -> Using two pointers
    public static int maxWaterPointers(int[] height) {
        int maxWater = 0, n = height.length;
        int left = 0, right = n - 1;

        while (left < right) {
            // Calculate the area of water between the two bars
            int water = Math.min(height[left], height[right]) * (right - left);
            // Update the maximum water area
            maxWater = Math.max(maxWater, water);

            // If the left bar is less than right one, move the left pointer
            if (height[left] < height[right])
                left++;
            else
                right--; // If the right bar is less than left one, move the right pointer
        }

        return maxWater;
    }
}
