public class CountNodes {

    // Reference Node record for tree
    public record Node(int value, Node left, Node right) {
    }

    // Approach-1 -> Using left and right height
    public static int countNodes(Node root) {

        // If the root is null, simply return 0
        if (root == null)
            return 0;

        // Find the left height
        int left = leftHeight(root.left);

        // Find the right height
        int right = rightHeight(root.right);

        // If both of them are equal, return the power of 2
        if (left == right)
            return (2 << left) - 1;

        // If not, go to left and right subtrees
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int rightHeight(Node root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    private static int leftHeight(Node root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }

}
