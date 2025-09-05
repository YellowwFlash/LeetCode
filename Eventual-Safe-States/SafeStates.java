import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeStates {

    // Approach-1 -> Using BFS and reverse graph
    public List<Integer> safeNodes(int V, ArrayList<ArrayList<Integer>> adj) {

        // Define a graph to represent the reverse graph
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<Integer>());
        }

        // Define an array to store the number of incoming edges for each node
        int[] inDegree = new int[V];

        // Build the reverse graph and increase the indegree from normal graph
        for (int i = 0; i < V; i++)
            for (int j : adj.get(i)) {
                reverseGraph.get(j).add(i);
                inDegree[i]++;
            }

        // Define a queue to perform BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // Add all nodes with no incoming edges to the queue
        for (int i = 0; i < V; i++)
            if (inDegree[i] == 0)
                queue.add(i);

        // Define a list of safe nodes
        List<Integer> safeNodes = new ArrayList<Integer>();

        // Perform BFS
        while (!queue.isEmpty()) {

            // Get the current node
            int node = queue.poll();

            // Add the current node in safe nodes
            safeNodes.add(node);

            // Decrease the number of incoming edges for each neighbor of the current node
            for (int neighbor : reverseGraph.get(node)) {
                if (inDegree[neighbor] != 0) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0)
                        queue.add(neighbor);
                }
            }

        }

        // Sort the list of safe nodes
        safeNodes.sort(null);

        // Return the list of safe nodes
        return safeNodes;
    }
}
