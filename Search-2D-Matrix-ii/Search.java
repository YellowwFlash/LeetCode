public class Search {

    // Approach-1 -> Using the standard qudratic search
    public static int[] searchLoops(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        // Ṣtart the traversal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If at any point, the element is same as target, return the indices
                if (matrix[i][j] == target)
                    return new int[] { i, j };
            }
        }

        // If no target is found, return -1
        return new int[] { -1, -1 };
    }

    // Approach-2 -> Using binary search on each array
    public static int[] searchLoopBinary(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        // Start the traversal
        for (int i = 0; i < n; i++) {

            // Do a binary search on each of the array
            int result = binarySearch(matrix[i], target, m);

            // Check if the result is not -1, -1
            if (result != -1)
                return new int[] { i, result };
        }

        // If no such element found, return -1, -1
        return new int[] { -1, -1 };
    }

    private static int binarySearch(int[] is, int target, int m) {

        // Ḍefine the search bounds
        int row = 0, col = m - 1;

        // Classic binary search
        while (row <= col) {

            // Find the mid
            int mid = row + (col - row) / 2;

            // Check if element at mid is the target
            if (is[mid] == target)
                return mid;

            // If element is greater than target, go to left
            else if (is[mid] > target)
                col = mid - 1;

            // If not, go to right
            else
                row = mid + 1;
        }

        return -1;
    }

    // Approach-3 -> Using conditional binary search (modified)
    public static int[] searchBinary(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        // Define the search bound
        int row = 0, col = m - 1;

        // Modified binary search
        while (row < n && col >= 0) {

            // Check if the current element at row col is the target
            if (matrix[row][col] == target)
                return new int[] { row, col };

            // If the current element is greater than target, reduce the column
            else if (matrix[row][col] > target)
                col--;

            // And if not, the just reduce the row
            else
                row++;
        }

        // If no target found, return -1, -1
        return new int[] { -1, -1 };
    }
}
