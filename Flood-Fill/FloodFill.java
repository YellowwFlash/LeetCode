public class FloodFill {

    // Approach-1 -> Using DFS Flood Fill algorithm
    public static void floodFill(int[][] image, int sr, int sc, int newColor) {

        // Get the current color
        int currentColor = image[sr][sc];

        // If the current color is the same as the new color, return
        if (currentColor == newColor)
            return;

        // Find the length of image
        int n = image.length, m = image[0].length;

        // Peform DFS on the image
        dfs(image, sr, sc, newColor, currentColor, n, m);
    }

    private static void dfs(int[][] image, int row, int col, int newColor, int currentColor, int n, int m) {

        // If the row or col is out of bounds or current pixel is not equal to current color, return
        if (row < 0 || col < 0 || row >= n || col >= m || image[row][col] != currentColor)
            return;

        // Paint the current pixel with new color
        image[row][col] = newColor;

        // Call dfs on all 4 directions
        dfs(image, row + 1, col, newColor, currentColor, n, m);
        dfs(image, row - 1, col, newColor, currentColor, n, m);
        dfs(image, row, col + 1, newColor, currentColor, n, m);
        dfs(image, row, col - 1, newColor, currentColor, n, m);
    }
}
