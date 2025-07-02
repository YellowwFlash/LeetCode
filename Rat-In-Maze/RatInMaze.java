import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    // Approach-1 -> Using recursion and backtracking
    public static List<String> ratInMaze(int[][] maze) {

        int n = maze.length;

        // Result List
        List<String> result = new ArrayList<>();

        // If maze is empty, return
        if (n == 0)
            return result;

        // Recursively find the solutions for maze
        findPath(maze, 0, 0, result, new StringBuilder(), n);

        // Return the final result with all the paths
        return result;
    }

    private static void findPath(int[][] maze, int row, int col, List<String> result, StringBuilder path, int n) {

        // if the row or col goes out of bound or current position is not 1
        if (row < 0 || row >= n || col < 0 || col >= n || maze[row][col] != 1)
            return;

        // Base case: At row and col reaching n
        if (row == n - 1 && col == n - 1) {

            // Add the current path to result
            result.add(path.toString());
            return;
        }

        // Mark the current position 0 as visited
        maze[row][col] = 0;

        // Append the choice of right
        path.append("R");

        // Move right
        findPath(maze, row, col + 1, result, path, n);

        // Backtracking from right since wrong path
        path.deleteCharAt(path.length() - 1);

        // Append the choice of left
        path.append("L");

        // Move left
        findPath(maze, row, col - 1, result, path, n);

        // Backtracking from left since wrong path
        path.deleteCharAt(path.length() - 1);

        // Append the choice of up
        path.append("U");

        // Move up
        findPath(maze, row - 1, col, result, path, n);

        // Backtracking from up since wrong path
        path.deleteCharAt(path.length() - 1);

        // Append the choice of down
        path.append("D");

        // Move down
        findPath(maze, row + 1, col, result, path, n);

        // Backtracking from down since wrong path
        path.deleteCharAt(path.length() - 1);

        // Move the current board position back to 1 for backtracking
        maze[row][col] = 1;

    }

}
