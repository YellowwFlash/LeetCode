public class SearchBST {

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

    // Approach-1 -> Using recursion
    public static Node searchBST(Node root, int key) {

        // Base case : If root is null or equals the key, return root
        if (root == null || root.data == key)
            return root;

        // If data of root is > key, go left else go right
        return searchBST((root.data > key) ? root.left : root.right, key);
    }

    // Variation-1 -> Find mix/max in BST
    public static int[] findMinMax(Node root) {

        // If root is null, simply return null
        if (root == null)
            return null;

        // Find the min using findmin method
        int min = findMin(root).data;

        // Find the max using findmax method
        int max = findMax(root).data;

        return new int[] { min, max };
    }

    private static Node findMin(Node root) {

        // If root is null, simply return null
        if (root == null)
            return root;

        // If the left child of root is null, return root
        if (root.left == null)
            return root;

        // Go to the left side if it exists
        return findMax(root.left);
    }

    private static Node findMax(Node root) {

        // If root is null, simply return null
        if (root == null)
            return root;

        // If the right child of root is null, return root
        if (root.right == null)
            return root;

        // Go to the right side if it exists
        return findMax(root.right);
    }
}
