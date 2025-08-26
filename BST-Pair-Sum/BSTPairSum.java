import java.util.ArrayList;
import java.util.List;

public class BSTPairSum {

    // Reference node class for BST
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Approach-1 -> Using the inorder traversal and two pointers
    public static boolean isPairPresent(Node root, int target) {

        // Define inorder list to store the inorder traversal
        List<Integer> inorder = new ArrayList<>();

        // Store the inorder traversal in the list
        inorder(root, inorder);

        // Find the answer using two pointers technique
        return twoSum(inorder, target);
    }

    private static boolean twoSum(List<Integer> inorder, int target) {

        // Define two pointers
        int left = 0, right = inorder.size() - 1;

        // Traverse the inorder list
        while (left < right) {

            // Get the sum of elements at left and right
            int sum = inorder.get(left) + inorder.get(right);

            // If the sum matches target, return true
            if (sum == target)
                return true;

            // If sum > k, move the right pointer
            else if (sum > target)
                right--;

            // If not, simply move the left pointer
            else
                left++;
        }

        // Return false since no such combination has been found
        return false;
    }

    private static void inorder(Node root, List<Integer> inorder) {

        // If root is null, return
        if (root == null)
            return;

        // Go to the left subtree
        inorder(root.left, inorder);

        // Add the current node
        inorder.add(root.data);

        // Go to the right subtree
        inorder(root.right, inorder);
    }
}
