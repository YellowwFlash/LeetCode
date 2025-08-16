import java.util.Stack;

public class FlattenBT {

    // Reference node class for tree
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
    public static Node reference = null;

    public static void flattenBTRecursion(Node root) {

        // Base case : If root is null, simply return
        if (root == null)
            return;

        // Go to the right subtree first to flatten
        flattenBTRecursion(root.right);

        // Go to the lefft subtree next to flatten
        flattenBTRecursion(root.left);

        // Set root's right to reference
        root.right = reference;

        // Set the left of root as null
        root.left = null;

        // Set reference to root
        reference = root;
    }

    // Approach-2 -> Using stack
    public static Node flattenBTStack(Node root) {

        // Define a stack for storing the nodes
        Stack<Node> stack = new Stack<>();

        // Add root node to stack
        stack.add(root);

        // Iterate until the stack is empty
        while (!stack.isEmpty()) {

            // Get the current node from stack
            Node current = stack.pop();

            // If current has right add it to stack
            if (current.right != null)
                stack.add(current.right);

            // If current has left add it to stack
            if (current.left != null)
                stack.add(current.left);

            // Set the current's right to top of the stack
            if (!stack.isEmpty())
                current.right = stack.peek();

            // Set the current's left to null
            current.left = null;
        }

        // Return the root of tree flattened as linkedlist
        return root;
    }

    // Approach-3 -> Using Morris Traversal
    public static Node flattenBTMorris(Node root) {

        // Define a reference node to traverse the tree
        Node current = root;

        // Traverse the whole tree
        while (current != null) {

            // If the current's left is non null
            if (current.left != null) {

                // Reference the left of current
                Node prev = current.left;

                // Find the rightest of current's left
                while (prev.right != null)
                    prev = prev.right;

                // Set the right of reference node to right of current
                prev.right = current.right;

                // Set the right of current to left of current
                current.right = current.left;

                // Set the left of current to null
                current.left = null;
            }

            // Move current to its right
            current = current.right;
        }

        // Return root node
        return root;
    }
}
