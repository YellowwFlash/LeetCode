import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {

    // Approach-1 -> Using DFS
    public static List<Integer> topoSortDFS(int[][] graph) {

        // Find the graph length
        int n = graph.length;

        // Define a boolean visited array to keep track of visited vertices
        boolean[] visited = new boolean[n];

        // Define a stack to store the topological order
        Stack<Integer> stack = new Stack<>();

        // Traverse through the graph
        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs(graph, visited, stack, i);

        // Define result list to store the topological order
        List<Integer> result = new ArrayList<>();

        // Pop elements from the stack and add them to the result list
        while (!stack.isEmpty())
            result.add(stack.pop());

        // Return the topological order
        return result;
    }

    private static void dfs(int[][] graph, boolean[] visited, Stack<Integer> stack, int vertex) {

        // If the vertex is already visited, return
        if (visited[vertex])
            return;

        // Mark the vertex as visited
        visited[vertex] = true;

        // Get the neighbors of the vertex
        int[] row = graph[vertex];

        // Traverse through the neighbors
        for (int i = 0; i < row.length; i++)
            if (row[i] != 0 && !visited[i])
                dfs(graph, visited, stack, i);

        // Push the vertex to the stack
        stack.push(vertex);
    }

    // Approach-2 -> Using Kahn's algorithm(BFS)
    public static List<Integer> topoSortBFS(int[][] graph) {

        // Find the graph length
        int n = graph.length;

        // Define an indegree array to keep track of the indegrees of vertices
        int[] indegree = new int[n];

        // Define a queue to store the vertices with zero indegree
        Queue<Integer> queue = new LinkedList<>();

        // Find the indegree of all the nodes adn store it accordingly
        for (int i = 0; i < n; i++)
            for (int j = 0; j < graph[i].length; j++)

                // If the element is not zero, then increment the indegree of the element
                if (graph[i][j] != 0)
                    indegree[j]++;

        // Push the vertices with zero indegree to the queue
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // Define a list to store the topological order
        List<Integer> result = new ArrayList<>();

        // Perform BFS
        bfs(graph, indegree, queue, result);

        // Return the topological order
        return result;
    }

    private static void bfs(int[][] graph, int[] indegree, Queue<Integer> queue, List<Integer> result) {

        // While the queue is not empty
        while (!queue.isEmpty()) {

            // Pop a vertex from the queue
            int vertex = queue.poll();

            // Add the vertex to the result list
            result.add(vertex);

            // Get the neighbors of the vertex
            int[] row = graph[vertex];

            // Traverse through the neighbors
            for (int i = 0; i < row.length; i++) {

                // If the element is not zero, then decrement the indegree of the element
                if (row[i] != 0) {
                    indegree[i]--;

                    // If the indegree of the element becomes zero, then push it to the queue
                    if (indegree[i] == 0)
                        queue.add(i);
                }
            }
        }
    }
}