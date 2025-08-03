public class Identical {

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

    // Appraoch-1 -> Using recursion
    public static boolean isIdentical(Node root1, Node root2) {

        // If both of the roots are null, they are identical
        if (root1 == null && root2 == null)
            return true;

        // If any one of them is null, they are not identical
        if (root1 == null || root2 == null)
            return false;

        // If their values are not equal, they are not identical
        if (root1.data != root2.data)
            return false;

        // Finally check for left and right subtree and return both of them
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
