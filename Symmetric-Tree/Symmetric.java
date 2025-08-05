public class Symmetric {

    // Reference Node record
    public record Node(int val, Node left, Node right) {
    }

    // Approach-1 -> Using dfs

    public static boolean isSymmetric(Node root) {

        // Check for the left and right subtrees together
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node left, Node right) {

        // If both the nodes are null, return true
        if (left == null && right == null)
            return true;

        // If any one of them is null individually, return false
        if (left == null || right == null)
            return false;

        // If the values are not equal, return false
        if (left.val != right.val)
            return false;

        // Go to left's left and right's right then left's right and right's left
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
