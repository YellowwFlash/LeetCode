public class MaximumRectangle {

    // Approach-1 -> Using previous and next smaller elements
    public static int maximumRectange(int[] heights) {

        // Find length of the heights array
        int n = heights.length, top = -1;

        // Create a stack to keep track of indices
        int[] stack = new int[n];

        // Traverse the heights for finding the max area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int currentHeight = heights[i];

            // Pop elements from stack till current height is < height at top of stack
            while (top != -1 && currentHeight <= heights[stack[top]]) {
                int height = heights[stack[top]];
                top--;

                // Calculate width
                int width = (top == -1) ? i : (i - stack[top] - 1);

                // Calculate area and update maxArea
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index onto stack
            stack[++top] = i;
        }
        
        // Handle remaining elements in the stack
        while (top != -1) {
            int height = heights[stack[top]];
            top--;

            // Calculate width
            int width = (top == -1) ? n : (n - stack[top] - 1);

            // Calculate area and update maxArea
            maxArea = Math.max(maxArea, height * width);
        }

        // Return max area as the final result
        return maxArea;                                                 
    }
}
