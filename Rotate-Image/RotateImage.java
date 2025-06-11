public class RotateImage {

    // Approach-1 -> Using inplace matrix transpose and swapping
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        // Now swap the columns in order until n/2
        for (int i = 0; i < (int) (n / 2); i++)
            for (int j = 0; j < n; j++)
                swap(matrix, i, n - i - 1, j);

    }

    private static void swap(int matrix[][], int col1, int col2, int row) {
        int temp = matrix[row][col1];
        matrix[row][col1] = matrix[row][col2];
        matrix[row][col2] = temp;
    }
}
