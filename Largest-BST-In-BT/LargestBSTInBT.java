public class LargestBSTInBT {

    // Reference node class for BST
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Reference Pair class for storing min, max and size values
    public static class Pair {
        int min;
        int max;
        int size;

        public Pair(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    // Approach-1 -> Using the postorder traversal
    public static int largestBST(Node root) {

        // Return the size of the largest BST
        return largest(root).size;
    }

    private static Pair largest(Node root) {

        // If the root is null, return the Pair with min, max and size as 0
        if (root == null)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // Go for the left subtree
        Pair left = largest(root.left);

        // Go for the right subtree
        Pair right = largest(root.right);

        // If the range of current node is defined, it is BST
        if (left.max < root.data && right.min > root.data)
            return new Pair(Math.min(left.min, root.data), Math.max(right.max, root.data), left.size + right.size + 1);

        // If not, its not a BST
        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
}
