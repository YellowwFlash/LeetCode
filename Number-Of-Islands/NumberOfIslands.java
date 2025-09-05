import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {

    // Approach-1 -> Using DFS
    public static int numberOfIslandsDFS(int[][] grid) {

        // Find the lengths of grid
        int m = grid.length, n = grid[0].length;

        // Initialize the count of islands
        int islands = 0;

        // Traverse over the grid and if the cell is 1 then call DFS
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, m, n);
                    islands++;
                }
        return islands;

    }

    private static void dfs(int[][] grid, int row, int col, int m, int n) {

        // If the cell is invalid or 0 then return
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0)
            return;

        // Mark the cell as visited
        grid[row][col] = 0;

        // Call DFS for all the 4 adjacent cells
        dfs(grid, row + 1, col, m, n);
        dfs(grid, row - 1, col, m, n);
        dfs(grid, row, col + 1, m, n);
        dfs(grid, row, col - 1, m, n);
    }

    // Variation-1(Only distinct islands with different shapes) -> Using DFS
    public static int numberOfDistinctIslandsDFS(int[][] grid) {

        // Find the lengths of grid
        int m = grid.length, n = grid[0].length;

        // Define a set that can store the directions of the distinct islands
        Set<String> set = new HashSet<>();

        // Traverse over the grid and if the cell is 1 then call DFS
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {

                    // Define a shape to store the directional shape
                    StringBuilder shape = new StringBuilder();

                    // Call for dfs for the cell
                    dfs(grid, i, j, m, n, shape, "S");

                    // Append the current shape in set
                    set.add(shape.toString());
                }

        // Return the size of the set as the number of distinct islands
        return set.size();
    }

    private static void dfs(int[][] grid, int row, int col, int m, int n, StringBuilder shape,
            String direction) {

        // If the cell is invalid or 0 then return
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0)
            return;

        // Mark the current cell as visited
        grid[row][col] = 0;

        // Append the direction to the shape
        shape.append(direction);

        // Call DFS for all the 4 adjacent cells
        dfs(grid, row + 1, col, m, n, shape, "D");
        shape.append("B");

        dfs(grid, row - 1, col, m, n, shape, "U");
        shape.append("B");

        dfs(grid, row, col + 1, m, n, shape, "R");
        shape.append("B");

        dfs(grid, row, col - 1, m, n, shape, "L");
        shape.append("B");
    }

    // Variation-2(Only distinct islands with different shapes) -> Using DFS and
    // coordinates
    public static int numberOfDistinctIslandsDFSWithCoordinates(int[][] grid) {

        // Find the lengths of grid
        int m = grid.length, n = grid[0].length;

        // Define a set that can store the directions of the distinct islands
        Set<String> set = new HashSet<>();

        // Traverse over the grid and if the cell is 1 then call DFS
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {

                    // Define a list to store the coordinates
                    List<String> shape = new ArrayList<>();

                    // Call for dfs for the cell
                    dfs(grid, i, j, m, n, shape, i, j);

                    // Append the current shape in set
                    set.add(String.join(",", shape));
                }

        // Return the size of the set as the number of distinct islands
        return set.size();
    }

    private static void dfs(int[][] grid, int row, int col, int m, int n, List<String> shape, int baseRow,
            int baseCol) {

        // If the cell is invalid or 0 then return
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0)
            return;

        // Mark the current cell as visited
        grid[row][col] = 0;

        // Add the coordinates of the current cell to the shape
        shape.add((row - baseRow) + ":" + (col - baseCol));

        // Call DFS for all the 4 adjacent cells
        dfs(grid, row + 1, col, m, n, shape, baseRow, baseCol);
        dfs(grid, row - 1, col, m, n, shape, baseRow, baseCol);
        dfs(grid, row, col + 1, m, n, shape, baseRow, baseCol);
        dfs(grid, row, col - 1, m, n, shape, baseRow, baseCol);
    }
}
