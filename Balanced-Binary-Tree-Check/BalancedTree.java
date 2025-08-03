public class BalancedTree {

    // Reference class Node for tree
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach-1 -> Using the height of tree
    public boolean isBalanced(Node root) {

        // Return if the height function is not returning -1
        return height(root) != -1;
    }

    private int height(BalancedTree.Node root) {

        // Base case : if the root is null, return 0
        if (root == null)
            return 0;

        // Calculate the height of the left subtree
        int leftHeight = height(root.left);

        // If the left height is -1, return -1
        if (leftHeight == -1)
            return -1;

        // Calculate the height of the right subtree
        int rightHeight = height(root.right);

        // If the right height is -1, return -1
        if (rightHeight == -1)
            return -1;

        // Check if the difference of both heights exceeds 1 or not
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // Return the max height of both of them
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
