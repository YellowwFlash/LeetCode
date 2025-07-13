public class MaximalRectangle {

    // Approach-1 -> Using histogram logic and prefix sum
    public static int maximalRectangle(int[][] matrix) {

        // If the matrix is empty, return 0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // Find lengths
        int rows = matrix.length, cols = matrix[0].length;

        // Define maxArea to store the maximum area found
        int maxArea = 0;

        // Create an array to store heights of histogram
        int[] heights = new int[cols];

        // Iterate through each row of the matrix
        for (int i = 0; i < rows; i++) {
            // Update heights for the current row
            for (int j = 0; j < cols; j++) {
                // If the cell is 1, increase height, else reset to 0
                heights[j] = (matrix[i][j] == 1) ? heights[j] + 1 : 0;
            }

            // Calculate maximum area for the histogram formed by heights
            maxArea = Math.max(maxArea, maxHistogramArea(heights));
        }

        // Return maximum area found as the final answer
        return maxArea;

    }

    private static int maxHistogramArea(int[] heights) {

        // Find length of the histogram and define top
        int n = heights.length, top = -1;

        // Create a stack to store indices of the histogram
        int[] stack = new int[n];

        // Initialize maximum area
        int maxArea = 0;

        // Iterate through each bar in the histogram
        for (int i = 0; i < n; i++) {

            // Pop elements from stack till current height is < height at top of stack
            while (top != -1 && heights[i] <= heights[stack[top]]) {
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

        // Return the maximum area found
        return maxArea;
    }
}
