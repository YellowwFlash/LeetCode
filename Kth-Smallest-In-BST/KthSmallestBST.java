import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST {

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

    // Approach-1 -> Using the inorder traversal
    public static Node kthSmallestInorder(Node root, int k) {

        // Define list to store the traversal
        List<Node> list = new ArrayList<>();

        // Find inorder traversal and store it in the list
        inorder(root, list);

        // Return the kth smallest element
        return list.get(k - 1);
    }

    private static void inorder(Node root, List<Node> list) {

        // Base case : If the root is null, return
        if (root == null)
            return;

        // Recursively call the left subtree
        inorder(root.left, list);

        // Add the current node to the list
        list.add(root);

        // Recursively call the right subtree
        inorder(root.right, list);
    }

    // Approach-2 -> Using index tracking
    public static int kthSmallest(Node root, int k) {

        // Define an array to store the current k and answer
        int[] result = new int[2];

        // The 1st index is k and 2nd is answer
        result[0] = k;

        // find the inorder traversal
        findInorder(root, result);

        // Return the kth smallest element
        return result[1];
    }

    private static void findInorder(Node root, int[] result) {

         // Base case : If the root is null, return
        if (root == null)
            return;

        // Recursively call the left subtree
        findInorder(root.left, result);

        // if the current k reaches 0, add answer as the current root
        if (--result[0] == 0) {
            result[1] = root.data;
            return;
        }

        // Recursively call the right subtree
        findInorder(root.right, result);
    }
}
