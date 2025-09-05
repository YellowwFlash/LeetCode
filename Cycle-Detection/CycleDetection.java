import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {

    // Approach-1 -> Using BFS and HashMap
    public boolean isCycleBFS(List<List<Integer>> graph) {

        // Define a boolean array to mark visited nodes
        boolean[] visited = new boolean[graph.size()];

        // Iterate over the graph
        for (int i = 0; i < graph.size(); i++)

            // If the node is not visited, perform BFS
            if (!visited[i] && bfs(graph, visited, i))
                return true;

        // Return false since the cycle does not exist
        return false;
    }

    private boolean bfs(List<List<Integer>> graph, boolean[] visited, int start) {

        // Define a hashmap to store the parent of each node
        HashMap<Integer, Integer> parent = new HashMap<>();

        // Define a queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the start node as visited and add it to the queue
        visited[start] = true;

        // Add the start node to the queue
        queue.add(start);

        // Set the parent of the start node as -1 since it has no parent
        parent.put(start, -1);

        // Perform BFS
        while (!queue.isEmpty()) {

            // Get the current node from the queue
            int node = queue.poll();

            // Get the list of neighbors of the current node
            List<Integer> neighbors = graph.get(node);

            // Iterate over the neighbors
            for (int neighbor : neighbors) {

                // If the neighbor is visited, check if it is the parent of the current node
                if (visited[neighbor] && parent.get(node) != neighbor)
                    // If not, return true since the cycle exists
                    return true;

                // If the neighbor is not visited, mark it as visited and add it to the queue
                if (!visited[neighbor]) {

                    // Mark the neighbor as visited
                    visited[neighbor] = true;

                    // Add the neighbor to the queue
                    queue.add(neighbor);

                    // Set the current node as the parent of the neighbor
                    parent.put(neighbor, node);

                }

            }
        }

        // Return false since there is no cycle
        return false;
    }

    // Approach-2 -> Using DFS
    public boolean isCycleDFS(List<List<Integer>> graph) {

        // Define a boolean array to mark visited nodes
        boolean[] visited = new boolean[graph.size()];

        // Iterate over the graph
        for (int i = 0; i < graph.size(); i++)

            // If the node is not visited, perform DFS
            if (!visited[i] && dfs(graph, visited, i, -1))
                return true;

        // Return false since the cycle does not exist
        return false;
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int parent) {

        // Mark the current node as visited
        visited[node] = true;

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(node)) {

            // If the neighbor is not visited, perform DFS
            if (!visited[neighbor]) {

                // If the DFS returns true, return true since the cycle exists
                if (dfs(graph, visited, neighbor, node))
                    return true;
            }

            // If neighbor is visited and is not parent, return true since cycle exists
            else if (neighbor != parent)
                return true;
        }

        // Return false since there is no cycle
        return false;
    }

    // Variation-1 -> Detecting cycle in directed graph
    public boolean isCycleDirected(List<List<Integer>> graph) {

        // Define a boolean array to mark visited nodes
        boolean[] visited = new boolean[graph.size()];

        // Define a boolean array to mark nodes in the current path
        boolean[] path = new boolean[graph.size()];

        // Iterate over the graph
        for (int i = 0; i < graph.size(); i++)

            // If the node is not visited, perform DFS
            if (!visited[i] && dfsDirected(graph, visited, path, i))
                return true;

        // Return false since the cycle does not exist
        return false;
    }

    private boolean dfsDirected(List<List<Integer>> graph, boolean[] visited, boolean[] path, int vertex) {

        // Mark the current node as visited and add it to the path
        visited[vertex] = true;
        path[vertex] = true;

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(vertex))

            // If the neighbor is not visited, perform DFS
            if (!visited[neighbor] && dfsDirected(graph, visited, path, neighbor))
                return true;

            // If neighbor is visited and is in path, return true since cycle exists
            else if (path[neighbor])
                return true;

        // Remove the current node from the path
        path[vertex] = false;
        return false;
    }
}
