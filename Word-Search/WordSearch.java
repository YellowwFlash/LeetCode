public class WordSearch {

    // Approach-1 -> Using recursion and backtracking
    public static boolean exists(char[][] board, String word) {

        // if board is empty or word is return false
        if (board.length == 0 || word.length() == 0)
            return false;

        int n = board.length, m = board[0].length;
        // Find the first char of word
        char first = word.charAt(0);

        // Loop through the board
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)

                // Only check if the first char is same as board one
                if (board[i][j] == first && doWordExist(board, word, i, j, n, m, 0))
                    // Return true since the word exists in the board
                    return true;

        // No such given word exists in board
        return false;
    }

    private static boolean doWordExist(char[][] board, String word, int row, int col, int n,
            int m, int index) {

        // First check if the row or col as out of the board
        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != word.charAt(index))
            return false;

        // Base case: When index reaches word's length
        if (index == word.length() - 1)
            return true;

        // Find current character
        char actual = board[row][col];

        // Change the current character to #
        board[row][col] = '#';

        boolean found = doWordExist(board, word, row, col + 1, n, m, index + 1) // Moving right
                || doWordExist(board, word, row, col - 1, n, m, index + 1) // Moving left
                || doWordExist(board, word, row - 1, col, n, m, index + 1) // Moving top
                || doWordExist(board, word, row + 1, col, n, m, index + 1); // Moving down

        // Backtrack by changing the current character with actual character
        board[row][col] = actual;

        // Return found since it will tell if the word is found or not
        return found;
    }
}
