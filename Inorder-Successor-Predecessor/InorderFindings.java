public class InorderFindings {

    // Reference node class for BST
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Variation-1(Successor) -> Using the find method of BST
    public static Node successorNode(Node root, int key) {

        // If the root is null, simply return null
        if (root == null)
            return null;

        // Define a successor node to keep track of the inorder successor
        Node successor = null;

        // Define current node for traversal
        Node current = root;

        // Traverse the tree
        while (current != null) {

            // If current's value is >= key, store it and go left for smallest possible
            if (current.data >= key) {
                successor = current;
                current = current.left;
            }

            // if not, simply go to right for the largest possible
            else
                current = current.right;
        }

        // Return the successor
        return successor;
    }

    // Variation-2(Predecessor) -> Using the find method of BST
    public static Node predecessorNode(Node root, int key) {

        // If the root is null, simply return null
        if (root == null)
            return null;

        // Define a predecessor node to keep track of the inorder predecessor
        Node predecessor = null;

        // Define current node for traversal
        Node current = root;

        // Traverse the tree
        while (current != null) {

            // If current's value is < key, store it and go right for largest possible
            if (current.data <= key) {
                predecessor = current;
                current = current.right;
            }

            // If not, go to left for the smallest possible
            else
                current = current.left;

        }

        // Return the predecessor
        return predecessor;
    }
}
