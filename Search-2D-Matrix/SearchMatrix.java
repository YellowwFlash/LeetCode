public class SearchMatrix {

    // Approach-1 -> Using quadratic search
    public static boolean searchLoops(int matrix[][], int target) {

        int n = matrix.length, m = matrix[0].length;

        // Start the traversal
        for (int i = 0; i < n; i++)
            // For each array
            for (int j = 0; j < m; j++)
                // If any element is equal to target, return true
                if (matrix[i][j] == target)
                    return true;

        return false;
    }

    // Approach-2 -> Using quadratic search with boundary check optimization
    public static boolean searchLoopsOptimized(int matrix[][], int target) {
        int n = matrix.length, m = matrix[0].length;

        // Start the traversal
        for (int i = 0; i < n; i++)

            // check if the current array will have the target or not
            if (matrix[i][0] <= target && matrix[i][m - 1] >= target)

                // For the specified array that contains target only
                for (int j = 0; j < m; j++) {
                    // If any element is equal to target, return true
                    if (matrix[i][j] == target)
                        return true;

                }

        return false;
    }

    // Approach-3 -> Using the binary search
    public static boolean searchBinary(int matrix[][], int target) {
        int n = matrix.length, m = matrix[0].length;

        // Start the traversal
        for (int i = 0; i < n; i++)

            // Check if the target is in current array or not
            if (matrix[i][0] <= target && matrix[i][m - 1] >= target)
                // Perform binary search on the current array
                return binarySearch(matrix[i], target, m);

        return false;
    }

    private static boolean binarySearch(int[] nums, int target, int n) {

        int low = 0, high = n - 1;

        // Perform standard binary search
        while (low <= high) {

            // Find the mid
            int mid = (low + high) / 2;

            // Check if mid is the target
            if (nums[mid] == target)
                return true;

            // If the element at mid is greater than target, go to left
            else if (nums[mid] > target)
                high = mid - 1;
                
            // If not, simply go to right
            else
                low = mid + 1;
        }

        // If the target is not found
        return false;
    }

    // Approach-4 -> Using the flattening binary search technique
    public static boolean searchFlatten(int matrix[][], int target) {

        int n = matrix.length, m = matrix[0].length;

        // Define the search bounds
        int low = 0, high = n * m - 1;

        // Classic binary search
        while (low <= high) {

            // Find the mid
            int mid = (low + high) / 2;

            // Change the mid value to the row and column value using matrix lengths
            int row = mid / m;
            int col = mid % m;

            // Check if element at row and col is the target
            if (matrix[row][col] == target)
                return true;

            // If the element is greater, go to the left half
            else if (matrix[row][col] > target)
                high = mid - 1;

            // If not, simply go to the right half
            else
                low = mid + 1;
        }

        // If no such target found
        return false;
    }
}
