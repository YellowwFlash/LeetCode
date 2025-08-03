public class Height {

    // Reference node class for binary tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach-1 -> Using recursion
    public static int height(Node root) {

        // Base case : If root is null, return 0
        if (root == null)
            return 0;

        // Go to the left subtree and get max left height
        int leftHeight = height(root.left);

        // Go to the right subtree and get max right height
        int rightHeight = height(root.right);

        // Return the maximum height from both of them
        return Math.max(leftHeight, rightHeight) + 1;
    }
}