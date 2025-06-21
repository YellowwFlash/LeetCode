public class PeakElement {

    // Approach-1 -> Using the modified advanced binary search
    public static int[] peakElement(int[][] matrix) {

        int m = matrix[0].length;

        // Define the search bounds
        int low = 0, high = m - 1;

        // Modified binary search
        while (low <= high) {

            // Find the mid
            int mid = low + (high - low) / 2;

            // Find the row with max element
            int row = findMaxRow(matrix, mid);
            // Then find the left and right for the row
            int left = mid - 1 > 0 ? matrix[row][mid - 1] : -1;
            int right = mid + 1 < m ? matrix[row][mid + 1] : -1;

            // Check if the current left and right has the peak and return it if its
            if (left < matrix[row][mid] && right < matrix[row][mid])
                return new int[] { row, mid };

            // If any element is greater than the current, go to that direction
            else if (left > matrix[row][mid])
                high = mid - 1;

            // If not, then go to right
            else
                low = mid + 1;

        }

        return new int[] { -1, -1 };
    }

    private static int findMaxRow(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = 0, max = -1;

        for (int i = 0; i < n; i++) {
            if (matrix[i][mid] > max) {
                max = matrix[i][mid];
                row = i;
            }
        }

        return row;
    }
}
