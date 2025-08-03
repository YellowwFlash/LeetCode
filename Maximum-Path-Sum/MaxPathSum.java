public class MaxPathSum {

    // Reference Node class for tree
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

    // Approach-1 -> Using the max height fundamental
    public static int maxPathSum(Node root) {

        // Define a sum variable to keep track of max sum
        int[] sum = new int[1];

        // Assign the sum as min value
        sum[0] = Integer.MIN_VALUE;

        // Find the max path sum
        findMaxPathSum(root, sum);

        // Return sum as the final max path sum
        return sum[0];
    }

    private static int findMaxPathSum(MaxPathSum.Node root, int[] sum) {

        // Base case : If root is null, return 0
        if (root == null)
            return 0;

        // Find the max path sum of left subtree and discard -ve sums
        int left = Math.max(0, findMaxPathSum(root.left, sum));

        // Find the max path sum of right subtree and discard -ve sums
        int right = Math.max(0, findMaxPathSum(root.right, sum));

        // Update the max path sum
        sum[0] = Math.max(sum[0], left + right + root.data);

        // Return the max path sum of the current node
        return Math.max(left, right) + root.data;
    }

}
