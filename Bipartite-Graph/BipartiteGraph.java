import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    // Approach-1 -> Using BFS
    public boolean isBipartiteBFS(int[][] graph) {

        // Create a color array to store the color of the vertices.
        int[] colors = new int[graph.length];

        // Fill the color array with -1 to indicate that all vertices are uncolored.
        Arrays.fill(colors, -1);

        // Iterate through all the vertices and perform bfs on uncolored
        for (int i = 0; i < graph.length; i++)

            // If the vertex is uncolored, perform bfs on it
            if (colors[i] == -1 && !bfs(graph, colors, i, 0))
                // If the bfs fails, return false since graph isnt bipartite
                return false;

        // If the bfs passes for all vertices, return true since graph is bipartite
        return true;
    }

    private boolean bfs(int[][] graph, int[] colors, int current, int color) {

        // Define a queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();

        // Add the current vertex to the queue and color it with the given color
        queue.add(new int[] { current, color });

        // Perform bfs on the current vertex
        while (!queue.isEmpty()) {

            // Get the next vertex from the queue
            int[] vertex = queue.poll();
            int vertexIndex = vertex[0];
            int vertexColor = vertex[1];

            // If the vertex is already colored with the different color, return false
            if (colors[vertexIndex] != -1 && colors[vertexIndex] != vertexColor)
                return false;

            // Color the vertex with the given color
            colors[vertexIndex] = vertexColor;

            // Iterate through all the neighbors of the vertex
            for (int neighbor : graph[vertexIndex])

                // If the neighbor is uncolored, add it to the queue with the opposite color
                if (colors[neighbor] == -1)
                    queue.add(new int[] { neighbor, 1 - vertexColor });

        }

        // Return true since the current bfs is successful
        return true;
    }

    // Approach-2 -> Using DFS
    public boolean isBipartiteDFS(int[][] graph) {

        // Create a color array to store the color of the vertices.
        int[] colors = new int[graph.length];

        // Fill the color array with -1 to indicate that all vertices are uncolored.
        Arrays.fill(colors, -1);

        // Iterate through all the vertices and perform dfs on uncolored
        for (int i = 0; i < graph.length; i++)

            // If the vertex is uncolored, perform dfs on it
            if (colors[i] == -1 && !dfs(graph, colors, i, 0))
                // If the dfs fails, return false since graph isnt bipartite
                return false;

        // If the dfs passes for all vertices, return true since graph is bipartite
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int vertex, int color) {

        // If the vertex is already colored, return if they have same color or not
        if (colors[vertex] != -1)
            return colors[vertex] == color;

        // Color the vertex with the given color
        colors[vertex] = color;

        // Iterate through all the neighbors of the vertex
        for (int neighbor : graph[vertex])

            // Perform dfs on neighbors with the opposite color
            if (!dfs(graph, colors, neighbor, 1 - color))
                // If the dfs fails, return false
                return false;

        // Return true since the current dfs is successful
        return true;
    }
}
