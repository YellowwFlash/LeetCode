public class DeleteNodeBST {

    // Reference Node class for BST
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

    // Approach-1 -> Using the tree traversal
    public static Node deleteNode(Node root, int val) {

        // If root is null, return null
        if (root == null)
            return null;

        // If the value is root, return the helper method
        if (root.data == val)
            return deleteNodeHelper(root);

        // Traverse the whole tree using reference Node
        Node current = root;

        while (current != null) {

            // If the current value is > val, go left
            if (current.data > val) {

                // If the left child is non null and is the val node, update the current
                if (current.left != null && current.left.data == val) {
                    current.left = deleteNodeHelper(current.left);
                    break;
                } else {
                    // Move the current to the left
                    current = current.left;
                }
            }

            // If not, go to right
            else {
                // If the right child is non null and is the val node, update the current
                if (current.right != null && current.right.data == val) {
                    current.right = deleteNodeHelper(current.right);
                    break;
                } else {
                    // Move the current to the right
                    current = current.right;
                }
            }

        }

        // Return root of the updated tree
        return root;
    }

    private static Node deleteNodeHelper(Node root) {

        // If the root is null, return null
        if (root == null)
            return null;

        // If the left of root is null, return right
        if (root.left == null)
            return root.right;

        // If the right of root is null, return left
        if (root.right == null)
            return root.left;

        // if both are non null, attach right subtree to left subtree
        Node right = root.right;

        // Find the rightest node in left subtree
        Node rightest = findRightest(root.left);

        // Attach the right to rightest's right
        rightest.right = right;

        // Return the left child of root as new node
        return root.left;
    }

    private static Node findRightest(Node root) {

        // If the right of the root is null, return root
        if (root.right == null)
            return root;

        return findRightest(root.right);
    }
}
