import java.util.HashMap;

public class BuildTree {

    // Reference Node class for trees
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

    // Variation-1 -> Build tree using inorder and preorder traversals
    public static Node buildTreeInPre(int[] inOrder, int[] preOrder) {

        // Define a hashmap to store the index of each element in inorder array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++)
            map.put(inOrder[i], i);

        // Define a recursive function to build the tree
        return buildInPre(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
    }

    private static Node buildInPre(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {

        // If the preorder or inorder are empty return null
        if (preStart > preEnd || inStart > inEnd)
            return null;

        // Find the current root data using preorder
        int rootData = preOrder[preStart];

        // Find the left elements
        int leftSize = map.get(rootData) - inStart;

        // Create the root node
        Node root = new Node(rootData);

        // For the left subtree, call the recursive function
        root.left = buildInPre(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, map.get(rootData) - 1,
                map);

        // For the right subtree, call the recursive function
        root.right = buildInPre(preOrder, preStart + leftSize + 1, preEnd, inOrder, map.get(rootData) + 1, inEnd, map);

        // Return the current root
        return root;
    }

    // Variation-2 -> Build tree using inorder and postorder traversals
    public static Node buildTreeInPost(int[] inOrder, int[] postOrder) {

        // Define a hashmap to store the index of each element in inorder array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++)
            map.put(inOrder[i], i);

        // Define a recursive function to build the tree
        return buildInPost(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1, map);

    }

    private static Node buildInPost(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {

        // If the preorder or inorder are empty return null
        if (postStart > postEnd || inStart > inEnd)
            return null;

        // Find the current root data using postorder
        int rootData = postOrder[postEnd];

        // Get the rootdata index from map
        int index = map.get(rootData);

        // Find the left size of elements
        int leftSize = index - inStart;

        // Create the root node
        Node root = new Node(rootData);

        // For the left subtree, call the recursive function
        root.left = buildInPost(postOrder, postStart, postStart + leftSize - 1, inOrder, inStart, map.get(rootData) - 1,
                map);

        // For the right subtree, call the recursive function
        root.right = buildInPost(postOrder, postStart + leftSize, postEnd - 1, inOrder,
                map.get(rootData) + 1, inEnd, map);

        // Return the current root
        return root;
    }

}
