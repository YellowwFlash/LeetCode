public class RecoverBST {

    // Reference node class for BST
    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Approach-1 -> Using the inorder traversal
    // Define global nodes
    Node first = null, second = null, last = null, prev = null;

    public void recoverTree(Node root) {

        // Call for the inorder
        inorder(root);

        // If the first and last nodes are non null, swap the data(non adjacent)
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }

        // If the first and second nodes are non null, swap the data(adjacent)
        else if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    private void inorder(Node root) {

        // If the root is null, return
        if (root == null)
            return;

        // Go to the left subtree
        inorder(root.left);

        // If the prev is non null, check for anamoly
        if (prev != null && prev.data > root.data) {

            if (first == null) {
                // First would be prev and second would be root
                first = prev;
                second = root;
            } else
                last = root;
        }

        // Assign prev as current node
        prev = root;

        // Go to the right subtree
        inorder(root.right);
    }
}
