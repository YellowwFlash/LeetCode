public class ConstructBST {

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

    // Approach-1 -> Using recursion
    public static Node constructBST(int[] preorder) {

        // If the array is empty, return null
        if (preorder.length == 0)
            return null;

        // Build the BST using the preorder traversal
        return buildBST(preorder, Integer.MAX_VALUE, new int[1]);
    }

    private static ConstructBST.Node buildBST(int[] preorder, int bound, int[] index) {

        // If index is out of bounds or current element is out of range, return null
        if (index[0] >= preorder.length || preorder[index[0]] > bound)
            return null;

        // Construct the root node
        Node root = new Node(preorder[index[0]++]);

        // Construct the left subtree
        root.left = buildBST(preorder, root.data, index);

        // Construct the right subtree
        root.right = buildBST(preorder, bound, index);

        // Return the root of the tree
        return root;
    }
}
