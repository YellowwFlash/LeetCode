import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    // Approach-1 -> Using graph and dfs
    public static int findProvincesConversion(int[][] isConnected) {

        // Create a graph(adjacency list) from the given isConnected matrix
        List<List<Integer>> graph = new ArrayList<>();

        // Convert the isConnected matrix into a graph
        convert(isConnected, graph);

        // Create a visited array to keep track of visited vertices
        int n = isConnected.length;
        boolean[] visited = new boolean[n + 1];

        // Define provinces to keep track of the total number of provinces
        int provinces = 0;

        // Perform DFS on each unvisited vertex
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {

                // Increase the provinces
                provinces++;

                // Perform dfs on the current unvisited vertex
                dfs(i, graph, visited);
            }
        }

        // Return provinces as the final answer
        return provinces;
    }

    private static void convert(int[][] isConnected, List<List<Integer>> graph) {

        // Initialize the graph with empty lists for each vertex
        for (int i = 0; i <= isConnected.length; i++)
            graph.add(new ArrayList<>());

        // Populate the graph with edges based on the isConnected matrix
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i + 1).add(j + 1);
                    graph.get(j + 1).add(i + 1);
                }
            }
        }
    }

    private static void dfs(int i, List<List<Integer>> graph, boolean[] visited) {

        // Mark the current vertex as visited
        visited[i] = true;

        // Iterate over the neighbors of the current vertex
        for (int neighbor : graph.get(i))

            // If the neighbour is not visited, perform dfs on it
            if (!visited[neighbor])
                dfs(neighbor, graph, visited);

    }

    // Approach-2 -> Using matrix and dfs
    public static int findProvinces(int[][] isConnected) {

        // Define a visited array to keep track of visited vertices
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        // Define provinces to keep track of the total number of provinces
        int provinces = 0;

        // Traverse the matrix and perform dfs on unvisited vertices
        for (int i = 0; i < n; i++) {

            // If the current vertex is unvisited, perform dfs on it
            if (!visited[i]) {

                // Increase the provinces
                provinces++;

                // Perform dfs on the current unvisited vertex
                dfsModified(i, isConnected, visited);
            }
        }

        // Return provinces as the final answer
        return provinces;
    }

    private static void dfsModified(int vertex, int[][] isConnected, boolean[] visited) {

        // Get the neighbours of the current vertex
        int[] neighbours = isConnected[vertex];

        // Mark the current vertex as visited
        visited[vertex] = true;

        // Iterate over the neighbours of the current vertex and peform dfs
        for (int i = 0; i < neighbours.length; i++) {

            // If the neighbour is not visited, perform dfs on it
            if (neighbours[i] == 1 && !visited[i])
                dfsModified(i, isConnected, visited);
        }
    }

}
