import java.util.ArrayList;
import java.util.List;

public class NodePath {

    // Reference Node record for tree
    public record Node(int value, Node left, Node right) {
    }

    // Approach-1 -> Using dfs and recursion
    public static List<Integer> findPath(Node root, int target) {

        // If root is null, simply return an empty list
        if (root == null)
            return List.of();

        // Define result list to keep track of the result
        List<Integer> result = new ArrayList<>();

        // Find the path from root to given node using dfs
        if (dfs(root, target, result))

            // Return the result
            return result;

        return List.of();
    }

    private static boolean dfs(Node root, int target, List<Integer> result) {

        // If root is null, simply return
        if (root == null)
            return false;

        // Add the value of root to the result
        result.add(root.value);

        // If the value of root is equal to target, return true
        if (root.value == target)
            return true;

        // Recursively call dfs on left and right subtree and if found return true
        if (dfs(root.left, target, result) || dfs(root.right, target, result))
            return true;

        // Remove the last element from the result list
        result.remove(result.size() - 1);

        // Return false since the current iteration does not have the target value
        return false;
    }
}
