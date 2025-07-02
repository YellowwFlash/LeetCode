import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    // Approach-1 -> Using recursion and backtracking
    public static List<List<String>> nQueens(int n) {

        // Define a char board and init the whole of it with '.'
        char[][] board = new char[n][n];

        for (char row[] : board)
            Arrays.fill(row, '.');

        // Result list
        List<List<String>> result = new ArrayList<>();

        placeQueens(board, result, n, 0);

        // Return the final list
        return result;

    }

    private static void placeQueens(char[][] board, List<List<String>> result, int n, int row) {

        // Base case: At col reaching n
        if (row == n)
            // Add the current board in result
            result.add(constructBoard(board));

        // Loop through all the rows and find placement for queen at col
        for (int col = 0; col < n; col++) {

            // Check if the placemenet of queen is safe at current row and col
            if (isSafe(board, row, col, n)) {

                // Place the queen at current position
                board[row][col] = 'Q';

                // Recursively find placement for the next queen
                placeQueens(board, result, n, row + 1);

                // Backtrack by removing the queen at current position
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {

        // Check if queen exists in current col
        for (int i = row - 1; i >= 0; i--)
            if (board[i][col] == 'Q')
                return false;

        // Check for diagonally up left for queen
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check for diagonally up right for queen
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        // Return true since there is no queen and its safe to place the queen
        return true;
    }

    private static List<String> constructBoard(char[][] board) {

        List<String> result = new ArrayList<>();

        // Join the char array into single string
        for (char row[] : board)
            result.add(new String(row));

        // Return the result
        return result;
    }
}
