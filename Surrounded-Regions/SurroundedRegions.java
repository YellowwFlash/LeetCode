public class SurroundedRegions {

    // Approach-1 -> Using boundary DFS
    public static void solve(char[][] board) {

        // Find the lengths of board
        int m = board.length, n = board[0].length;

        // Traverse the top row
        for (int i = 0; i < n; i++)
            if (board[0][i] == 'O')
                dfs(0, i, board, m, n);

        // Traverse the bottom row
        for (int i = 0; i < n; i++)
            if (board[m - 1][i] == 'O')
                dfs(m - 1, i, board, m, n);

        // Traverse the leftmost column
        for (int i = 0; i < m; i++)
            if (board[i][0] == 'O')
                dfs(i, 0, board, m, n);

        // Traverse the rightmost column
        for (int i = 0; i < m; i++)
            if (board[i][n - 1] == 'O')
                dfs(i, n - 1, board, m, n);

        // Traverse the board and change the Os to Xs
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';

    }

    private static void dfs(int row, int col, char[][] board,int m, int n) {

        // If the row or column is out of bounds or cell is return
        if (row < 0 || col < 0 || row >= m || col >= n ||  board[row][col] == 'X' || board[row][col] == '#')
            return;

        // First mark the current cell as visited
        board[row][col] = '#';

        // Traverse in all the 4 directions
        dfs(row - 1, col, board, m, n); // Up
        dfs(row + 1, col, board, m, n); // Down
        dfs(row, col - 1, board, m, n); // Left
        dfs(row, col + 1, board, m, n); // Right
    }
}
