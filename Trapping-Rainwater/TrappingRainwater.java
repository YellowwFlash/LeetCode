public class TrappingRainwater {

    // Approach-1 -> Using the prefix and suffix max
    public static int trapPrefixSuffixMax(int[] heights) {
        int n = heights.length;
        int prefix[] = new int[n], suffix[] = new int[n];
        prefix[0] = heights[0];

        // First forward traversal for finding the prfix maximum
        for (int i = 1; i < n; i++)
            prefix[i] = Math.max(prefix[i - 1], heights[i]);

        // Backward traversal for finding the suffix maximum
        suffix[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = Math.max(suffix[i + 1], heights[i]);

        // Final traversal of heights to get the water
        int water = 0;
        for (int i = 0; i < n; i++)
            water += Math.min(prefix[i], suffix[i]) - heights[i];

        return water;
    }

    // Approach-2 -> Using the two pointers technique
    public static int trapTwoPointers(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;

        // Traversal of left and right pointers
        while (left < right) {

            // First if the element at left pointer is less than that of right one
            if (heights[left] < heights[right]) {
                // If the maxLeft is greater than element at left pointer, increase the water
                if (maxLeft > heights[left])
                    water += maxLeft - heights[left]; // Add the difference of both to get smallest water value
                else
                    maxLeft = heights[left]; // Update the maxLeft value
                left++;
            }

            // If the element at right pointer is less than that of left one
            else {
                // If the maxRight is greater than element at right pointer, increase the water
                if (maxRight > heights[right])
                    water += maxRight - heights[right]; // Add the difference of both to get smallest water valu
                else
                    maxRight = heights[right]; // Update the maxRight value
                right--;
            }
        }

        return water;
    }
}