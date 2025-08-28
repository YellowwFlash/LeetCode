import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    // Reference Pair class for row, col and time
    public static class Pair {
        int row, col, time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    // Approach-1 -> Using BFS
    public static int rottenOranges(int[][] grid) {

        // Find the lengths of the grid
        int m = grid.length, n = grid[0].length;

        // Define a queue to perform BFS
        Queue<Pair> queue = new LinkedList<>();

        // Keep a counter for counting the fresh oranges
        int fresh = 0;

        // Initialize the queue with the rotten oranges
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

                // If the orange is fresh, increment the counter
                if (grid[i][j] == 1)
                    fresh++;

                // If the orange is rotted, add it to the queue
                if (grid[i][j] == 2)

                    // Add the rotten orange to the queue
                    queue.add(new Pair(i, j, 0));
            }

        // Define the directions in which the oranges can spread
        int[] rotRow = { -1, 0, 1, 0 };
        int[] rotCol = { 0, 1, 0, -1 };

        // Define the time to be 0
        int time = 0;

        // Perform BFS
        while (!queue.isEmpty()) {

            // Get the current Pair
            Pair current = queue.poll();

            // Get the row, col and time
            int row = current.row;
            int col = current.col;
            int t = current.time;

            // Update the time
            time = Math.max(time, t);

            // Rot the oranges in the current direction
            for (int i = 0; i < 4; i++) {

                // Get the new row and col
                int newRow = row + rotRow[i];
                int newCol = col + rotCol[i];

                // Check if the new row and col are valid
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {

                    // Since a fresh orange is rotten, decrement the counter
                    fresh--;

                    // Add the new orange to the queue
                    queue.add(new Pair(newRow, newCol, t + 1));

                    // Mark the orange as rotted
                    grid[newRow][newCol] = 2;
                }
            }
        }

        // If there are any fresh oranges left, return -1 else return the time
        return fresh == 0 ? time : -1;
    }
}