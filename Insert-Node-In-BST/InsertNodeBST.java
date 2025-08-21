public class InsertNodeBST {

    // Reference node class for BST
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach-1 -> Using tree traversal
    public static Node insertNode(Node root, int val) {

        // If the root is null, return the new node
        if (root == null)
            return new Node(val);

        // Reference node for traversal
        Node current = root;

        // Traverse the BST
        while (true) {

            // If the current root values is > val, go to left
            if (current.data > val) {

                // If the left node exists, go to left
                if (current.left != null) {
                    current = current.left;
                } else {
                    // If left node is null, insert the node
                    current.left = new Node(val);
                    break;
                }
            }

            // If not go to right
            else {
                // If the right node exists, go to right
                if (current.right != null) {
                    current = current.right;
                } else {
                    // If right node is null, insert the node
                    current.right = new Node(val);
                    break;
                }
            }
        }

        // Return the root of the updated tree
        return root;
    }
}
