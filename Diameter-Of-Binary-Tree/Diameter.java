public class Diameter {

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

    // Approach-1 -> Using height and diameter
    public static int diameter(Node root) {

        // Define diameter array to keep track of diameter
        int[] diameter = new int[1];

        // Find height and diameter
        height(root, diameter);

        // Return diameter as the final answer
        return diameter[0];
    }

    private static int height(Diameter.Node root, int[] diameter) {

        // Base case : if root is null, return 0
        if (root == null)
            return 0;

        // Find the height of left subtree
        int left = height(root.left, diameter);

        // Find the height of right subtree
        int right = height(root.right, diameter);

        // Update the diameter
        diameter[0] = Math.max(diameter[0], left + right);

        // Return the height of the current node
        return Math.max(left, right) + 1;
    }
}
