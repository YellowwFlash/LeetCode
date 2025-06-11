public class SetMatrixZeros {

    // Approach-1 -> Using extra space
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // Make extra markers
        int rows[] = new int[m], cols[] = new int[n];

        // Mark the markers
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0)
                    rows[i] = cols[j] = 1;

        // Use the markers to remark the current matrix
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rows[i] == 1 || cols[j] == 1)
                    matrix[i][j] = 0;
    }

    // Approach-2 -> In place settings
    public static void setZeroesOptimized(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // Speacial marker
        int col0 = 1;

        // Mark the markers
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    // Mark the row
                    matrix[i][0] = 0;
                    // Mark the column
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }

        // Use the markers to set zeros
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // If current element in non zero, then check for zero
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
            }
        }

        // For the 1st row
        if (matrix[0][0] == 0)
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;

        // For the 1st col
        if (col0 == 0)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }

}
