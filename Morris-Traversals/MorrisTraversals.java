import java.util.ArrayList;
import java.util.List;

public class MorrisTraversals {

    // Reference node class for trees
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Traversal-1 -> Inorder Traversal
    public static List<Integer> inOrder(Node root) {

        // Define a result list
        List<Integer> result = new ArrayList<>();

        // Define a current node referenced to traverse the tree
        Node current = root;

        // Traverse the whole tree
        while (current != null) {

            // If the current node's left is null
            if (current.left == null) {

                // Add current node to result
                result.add(current.data);

                // Move to the right
                current = current.right;
            } else {

                // Find the left of current node
                Node left = current.left;

                // Traverse the left node to the rightest child
                while (left.right != null && left.right != current)
                    left = left.right;

                // If the rightest child is null
                if (left.right == null) {

                    // Assign the right of the child to current
                    left.right = current;

                    // Move the current to left
                    current = current.left;
                }

                // If the child is non null, remove the link
                else {

                    // Remove the link
                    left.right = null;

                    // Add the current node in list since the left tree is done
                    result.add(current.data);

                    // Move to the right
                    current = current.right;
                }
            }
        }

        // Return result as the final inorder Traversal
        return result;
    }

    // Traversal-2 -> Preorder Traversal
    public static List<Integer> preOrder(Node root) {

        // Define a result list
        List<Integer> result = new ArrayList<>();

        // Define a current node referenced to traverse the tree
        Node current = root;

        // Traverse the whole tree
        while (current != null) {

            // If the left of current is null, simply go to right
            if (current.left == null) {

                // Add the current root in result list
                result.add(current.data);

                // Move to the current's right
                current = current.right;
            }

            // If not, find the rigthest child of current's left and link it
            else {

                // Find the rigthest child of current's left
                Node left = current.left;

                while (left.right != null && left.right != current)
                    left = left.right;

                // If the rigthest child is null
                if (left.right == null) {

                    // Add the left node in result list
                    result.add(current.data);

                    // Link the rigthest child of current's left to current
                    left.right = current;

                    // Move to the left
                    current = current.left;
                }

                // If the rigthest child is not null, remove the link and move to right
                else {

                    // Remove the link
                    left.right = null;

                    // Move to the right
                    current = current.right;
                }
            }
        }

        // Return result list
        return result;
    }
}
