import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    // Reference Node record for tree
    public record Node(int data, Node left, Node right) {
    }

    // Approach-1 -> Using Paths to find LCA
    public static int findLCAPathList(Node root, int n1, int n2) {

        // If root is null, simply return -1
        if (root == null) {
            return -1;
        }

        // Define two lists to store the paths of both nodes
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        // Call the recursive function to find the paths
        findPath(root, n1, path1);
        findPath(root, n2, path2);

        // If both paths are not found, return -1
        if (path1.size() == 0 || path2.size() == 0)
            return -1;

        int common = -1;

        // Find the common node from the two paths
        for (int element : path1)
            if (path2.contains(element))
                common = element;

        // Return the common node
        return common;
    }

    private static boolean findPath(Node root, int target, List<Integer> path1) {

        // If root is null, simply return false
        if (root == null)
            return false;

        // Add the current node's data to the path list
        path1.add(root.data);

        // If the current node's data matches target, return true
        if (root.data == target)
            return true;

        // If the target is found in the left or right subtree, return true
        if (findPath(root.left, target, path1) || findPath(root.right, target, path1))
            return true;

        // remove the current node's data from the path list
        path1.remove(path1.size() - 1);
        return false;
    }

    // Approach-2 -> Using plain simple DFS
    public static Node findLCA(Node root, int n1, int n2) {

        // If root is null or root is either n1 or n2, return root
        if (root == null || root.data == n1 || root.data == n2)
            return root;

        // Find LCA for left subtree
        Node left = findLCA(root.left, n1, n2);

        // Find lCA for right subtree
        Node right = findLCA(root.right, n1, n2);

        // If left is null, return right
        if (left == null)
            return right;

        // If right is null, return left
        if (right == null)
            return left;

        // If both left and right are not null, return root
        return root;
    }
    
    // Variation-1 -> If its a BST
    public static Node findLCABST(Node root, int n1, int n2) {

        // If root is null, return null
        if (root == null)
            return null;

        // Get the value of current node
        int curr = root.data;

        // If curr > n1 and n2, go to left subtree
        if (curr > n1 && curr > n2)
            return findLCABST(root.left, n1, n2);

        // if curr < n1 and n2, go to right subtree
        if (curr < n1 && curr < n2)
            return findLCABST(root.right, n1, n2);

        // if both conditions fail, return root since its intersection point
        return root;
    }
}
