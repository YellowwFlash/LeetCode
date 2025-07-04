public class SudokuSolver {

    // Approach-1 -> Using recursion and backtracking
    public static void solveSudoku(char[][] board) {

        solve(board);
    }

    private static boolean solve(char[][] board) {

        // Traverse the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // if the current board element is empty then only check
                if (board[i][j] == '.') {

                    // First check if the current position is valid or not for 1 to 9
                    for (char c = '1'; c <= '9'; c++) {

                        // If the current position is valid for current character
                        if (isValid(board, i, j, c)) {

                            // Change the board's current to c
                            board[i][j] = c;

                            // Check if this can be further solvable and is correct solution
                            if (solve(board))
                                return true;

                            // If not change the board back to empty since the given solution is incorrect
                            else
                                board[i][j] = '.';
                        }
                    }

                    // Return false since none of the chars worked out so no solution possible
                    return false;
                }
            }
        }

        // Return true since the board is now solved
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char current) {

        // Check for the entire row or col for the same character
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == current || board[i][col] == current)
                return false;

        // Grid check
        int boxRow = (row / 3) * 3, boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++)
            for (int j = boxCol; j < boxCol + 3; j++)
                if (board[i][j] == current)
                    return false;

        // Return true since its valid for the current char
        return true;
    }
}
