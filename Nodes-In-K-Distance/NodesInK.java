import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NodesInK {

    // Reference node class for tree
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach-1 -> Using parenting and dfs
    public static List<Integer> nodesInK(Node root, Node target, int k) {

        // If the root or the target is null, simply return an empty list
        if (root == null || target == null)
            return List.of();

        // Define a map to keep track of the parents
        Map<Node, Node> parents = new HashMap<>();

        // Add the parents of each node
        addParents(root, parents);

        // Keep a vistied set to keep track of visited nodes
        Set<Node> visited = new HashSet<>();

        // Define a result list to store the nodes in the k distance
        List<Integer> result = new ArrayList<>();

        // Perform a dfs from the target node
        dfs(target, k, visited, result, parents);

        // Return the result list
        return result;
    }

    private static void dfs(Node root, int k, Set<Node> visited, List<Integer> result, Map<Node, Node> parents) {

        // If root is null or k is less than 0 or root is already visited, return
        if (root == null || k < 0 || visited.contains(root))
            return;

        // If the k is 0, add the root data to the result list
        if (k == 0) {
            result.add(root.data);
            return;
        }

        // Mark the root as visited
        visited.add(root);

        // Perform dfs on the left and right child and parent of the root
        dfs(root.left, k - 1, visited, result, parents);
        dfs(root.right, k - 1, visited, result, parents);
        dfs(parents.get(root), k - 1, visited, result, parents);
    }

    private static void addParents(Node root, Map<Node, Node> parents) {

        // Define a queue to perform bfs
        Queue<Node> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.add(root);

        // Perform bfs
        while (!queue.isEmpty()) {
            // Get the current node
            Node current = queue.poll();

            // If the current node has left child, add it to queue and update its parent
            if (current.left != null) {
                queue.add(current.left);
                parents.put(current.left, current);
            }

            // If the current node has right child, add it to queue and update its parent
            if (current.right != null) {
                queue.add(current.right);
                parents.put(current.right, current);
            }
        }
    }
}
