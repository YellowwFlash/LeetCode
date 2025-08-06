public class ChildrenSumProperty {

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

    // Approach-1 -> Using dfs traversal and left and right checks
    public static void changeTree(Node root) {

        // If the root is null, return
        if (root == null)
            return;

        // Add the left and right children data to check
        int childs = (root.left == null ? 0 : root.left.data) + (root.right == null ? 0 : root.right.data);

        // If the childs have value exceeding root, change the root value
        if (childs >= root.data)
            root.data = childs;

        // If not, assign the value of the non null node to root
        else {
            if (root.left != null)
                root.left.data = root.data;
            else if (root.right != null)
                root.right.data = root.data;
        }

        // Call the function recursively for the left and right child
        changeTree(root.left);
        changeTree(root.right);

        // Change the root node
        int total = (root.left == null ? 0 : root.left.data) + (root.right == null ? 0 : root.right.data);

        // If any one of them is null, change root's data to total
        if (root.left == null || root.right == null)
            root.data = total;
    }
}