import java.util.Queue;
import java.util.LinkedList;

public class Matrix01 {

    // Approach-1 -> Using BFS
    public static int[][] updateMatrix(int[][] matrix) {

        // Find the lengths of matrix
        int m = matrix.length, n = matrix[0].length;

        // Define a boolean visited array for keeping track of the visited cells
        boolean[][] visited = new boolean[m][n];

        // Define a distance matrix as the final result matrix
        int[][] distance = new int[m][n];

        // Define a queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                // If the cell is a 0, add it to the queue and mark it as visited
                if (matrix[i][j] == 0) {

                    // Add the cell as row, col and distance
                    queue.add(new int[] { i, j });

                    // Mark the cell as visited
                    visited[i][j] = true;
                }

        // Perform BFS
        bfs(queue, visited, distance, matrix);

        // Return the distance matrix as the final result
        return distance;
    }

    private static void bfs(Queue<int[]> queue, boolean[][] visited, int[][] distance, int[][] matrix) {

        // Define the directions for moving in the matrix
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // Perform BFS
        while (!queue.isEmpty()) {

            // Get the current cell from the queue
            int[] current = queue.poll();

            // Get the row, column and distance of the current cell
            int row = current[0], col = current[1];

            // Iterate over the directions
            for (int[] dir : directions) {

                // Get the row and column of the next cell
                int nextRow = row + dir[0], nextCol = col + dir[1];

                // Check if the next cell is within the matrix and not visited
                if (nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[0].length
                        && !visited[nextRow][nextCol]) {

                    // Add the next cell to the queue
                    queue.add(new int[] { nextRow, nextCol });

                    // Mark the next cell as visited
                    visited[nextRow][nextCol] = true;

                    // Update the distance of the next cell
                    distance[nextRow][nextCol] = distance[row][col] + 1;
                }
            }
        }
    }
}
