import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    // Approach-1 -> Using boundary DFS
    public static int numberOfEnclavesDFS(int[][] grid) {

        // Find the lengths of grid
        int m = grid.length, n = grid[0].length;

        // Define a counter variable for counting the number of enclaves
        int enclaves = 0;

        // Define a visited array to keep track of the visited cells
        boolean[][] visited = new boolean[m][n];

        // Traverse the top and bottom boundary of grid
        for (int i = 0; i < n; i++) {

            // Check if the top and bottom boundary is land or not and call dfs
            if (grid[0][i] == 1 && !visited[0][i])
                dfs(grid, visited, 0, i, m, n);

            if (grid[m - 1][i] == 1 && !visited[m - 1][i])
                dfs(grid, visited, m - 1, i, m, n);

        }

        // Traverse the left and right boundary of grid
        for (int i = 0; i < m; i++) {

            // Check if the left and right boundary is land or not and call dfs
            if (grid[i][0] == 1 && !visited[i][0])
                dfs(grid, visited, i, 0, m, n);

            if (grid[i][n - 1] == 1 && !visited[i][n - 1])
                dfs(grid, visited, i, n - 1, m, n);
        }

        // Traverse the grid and count the number of enclaves
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    enclaves++;
            }
        }

        // Return the number of enclaves
        return enclaves;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col, int m, int n) {

        // Check for the cell validity and then check if the cell is land or not
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col])
            return;

        // Mark the cell as visited
        visited[row][col] = true;

        // Return the sum of the number of enclaves in the four directions

        dfs(grid, visited, row + 1, col, m, n);
        dfs(grid, visited, row - 1, col, m, n);
        dfs(grid, visited, row, col + 1, m, n);
        dfs(grid, visited, row, col - 1, m, n);
    }

    // Approach-2 -> Using multisource BFS
    public static int numberOfEnclavesBFS(int[][] grid) {
        // Find the lengths of grid
        int m = grid.length, n = grid[0].length;

        // Define a counter variable for counting the number of enclaves
        int enclaves = 0;

        // Define a visited array to keep track of the visited cells
        boolean[][] visited = new boolean[m][n];

        // Traverse the top and bottom boundary of grid
        for (int i = 0; i < n; i++) {

            // Check if the top and bottom boundary is land or not and call dfs
            if (grid[0][i] == 1 && !visited[0][i])
                bfs(grid, visited, 0, i, m, n);

            if (grid[m - 1][i] == 1 && !visited[m - 1][i])
                bfs(grid, visited, m - 1, i, m, n);

        }

        // Traverse the left and right boundary of grid
        for (int i = 0; i < m; i++) {

            // Check if the left and right boundary is land or not and call dfs
            if (grid[i][0] == 1 && !visited[i][0])
                bfs(grid, visited, i, 0, m, n);

            if (grid[i][n - 1] == 1 && !visited[i][n - 1])
                bfs(grid, visited, i, n - 1, m, n);
        }

        // Traverse the grid and count the number of enclaves
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    enclaves++;
            }
        }

        // Return the number of enclaves
        return enclaves;
    }

    private static void bfs(int[][] grid, boolean[][] visited, int row, int col, int m, int n) {

        // Define directions array
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // Define a queue for storing the cells
        Queue<int[]> queue = new LinkedList<>();

        // Mark the cell as visited and add it to the queue
        visited[row][col] = true;
        queue.add(new int[] { row, col });

        // Traverse the queue
        while (!queue.isEmpty()) {

            // Get the current cell from queue
            int[] cell = queue.poll();

            // Get the row and column of the current cell
            int r = cell[0], c = cell[1];

            // Traverse the four directions
            for (int[] dir : directions) {

                // Get the row and column of the next cell
                int nr = r + dir[0], nc = c + dir[1];

                // Check if the next cell is valid and land or not
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]) {

                    // Mark the next cell as visited
                    visited[nr][nc] = true;

                    // Add the next cell to the queue
                    queue.add(new int[] { nr, nc });
                }
            }
        }
    }
}