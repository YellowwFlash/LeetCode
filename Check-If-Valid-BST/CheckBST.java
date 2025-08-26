public class CheckBST {

    // Reference node class for BST
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

    // Approach-1 -> Using recursion and range technique
    public static boolean isBST(Node root) {

        // If the root is null, return true
        if (root == null)
            return true;

        // Return the check bst for left and right subtree
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean checkBST(Node root, long minValue, long maxValue) {

        // If the root is null, return true
        if (root == null)
            return true;

        // If the root value goes out of range, return false
        if (root.data <= minValue || root.data >= maxValue)
            return false;

        // Check for both left and right subtree
        return checkBST(root.left, minValue, root.data) && checkBST(root.right, root.data, maxValue);
    }
}
