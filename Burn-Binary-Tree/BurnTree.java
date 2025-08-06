import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurnTree {

    // Reference Node record for tree
    public record Node(int data, Node left, Node right) {
    }

    // Approach-1 -> Using dfs and max time tracking
    public static int burnTree(Node root, Node node) {

        // Define a map to store the parents of each node
        Map<Node, Node> parent = new HashMap<>();

        // Add parents to the map
        addParents(root, parent);

        // Initialize the min time to 0
        int[] time = new int[1];

        // Define a set to keep track of the visited nodes
        Set<Integer> visited = new HashSet<>();

        // Call the dfs function to find the time to burn the tree
        dfs(node, parent, visited, time, 0);

        // Return time as the min time to burn the tree
        return time[0];
    }

    private static void dfs(Node root, Map<Node, Node> parent,
            Set<Integer> visited, int[] time, int timeTaken) {

        // If root is null or already visited, simply return
        if (root == null || visited.contains(root.data))
            return;

        // Track the max time
        time[0] = Math.max(time[0], timeTaken);

        // Mark the current node as visited
        visited.add(root.data);

        // If current node has a left child, call dfs on it with updated timeTaken
        if (root.left != null)
            dfs(root.left, parent, visited, time, timeTaken + 1);

        // If current node has a right child, call dfs on it with updated timeTaken
        if (root.right != null)
            dfs(root.right, parent, visited, time, timeTaken + 1);

        // For current node with a parent, call dfs on it with updated timeTaken
        dfs(parent.get(root), parent, visited, time, timeTaken + 1);
    }

    private static void addParents(Node root, Map<Node, Node> parent) {

        // Define a queue to perform BFS
        Queue<Node> queue = new LinkedList<>();

        // Add root node to queue
        queue.add(root);

        // Iterate until the queue is empty
        while (!queue.isEmpty()) {
            // Get the current node from the queue
            Node current = queue.poll();

            // If current node has a left child, add it to queue and update its parent
            if (current.left != null) {
                queue.add(current.left);
                parent.put(current.left, current);
            }

            // If current node has a right child, add it to queue and update its parent
            if (current.right != null) {
                queue.add(current.right);
                parent.put(current.right, current);
            }
        }
    }
}
