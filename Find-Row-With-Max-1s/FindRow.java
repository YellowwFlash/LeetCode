public class FindRow {

    // Approach-1 -> Use a counter for each row
    public static int findRowCounter(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int row = -1, rowCount = 0;

        // Start the traversal
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == target)
                    count++;

            if (count > rowCount) {
                row = i;
                rowCount = count;
            }
        }

        return row;
    }

    // Approach-2 -> Using the counter method in optimized way
    public static int findRowCounterOptimized(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;
        int row = -1, rowCount = 0;

        // Start the traversal
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    count = m - j;
                    if (count > rowCount) {
                        row = i;
                        rowCount = count;
                    }
                    break;
                }
            }
        }

        return row;
    }

    // Approach-3 -> Using the first occurrence technique
    public static int findRowFirstOccurrence(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = -1, rowCount = -1;

        // Start the traversal
        for (int i = 0; i < n; i++) {

            // Get the first occurrence of target for each array
            int firstOccurrence = findFirstOccurrence(matrix[i], target);

            // Check for the count and update if necessary
            if (firstOccurrence != -1 && m - firstOccurrence > rowCount) {
                // Update the row with maximum target as current row
                row = i;
                // Update the row count with max occurrences
                rowCount = m - firstOccurrence;
            }
        }

        return row;
    }

    private static int findFirstOccurrence(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int firstOccurrence = -1;

        // Binary search
        while (left <= right) {

            // Find mid
            int mid = left + (right - left) / 2;

            // Check if mid is one of the target
            if (nums[mid] == target) {
                // Store mid as possible answer
                firstOccurrence = mid;
                // Go to left to find the first occurrence
                right = mid - 1;
            }

            // If the current number is greater than target, go to left
            else if (nums[mid] > target)
                right = mid - 1;

            // If the current number is smaller than target, go to right
            else
                left = mid + 1;
        }

        return firstOccurrence;
    }
}
