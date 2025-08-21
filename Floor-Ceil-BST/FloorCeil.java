public class FloorCeil {

    // Reference Node class for BST
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Approach-1 -> Using recursion
    public static Node[] floorCeil(Node root, int key) {

        // If the root is null, simply return null
        if (root == null)
            return null;

        // Find the floor using findFloor method
        Node floor = findFloor(root, null, key);

        // Find the ceil using findCeil method
        Node ceil = findCeil(root, null, key);

        // Return both floor and ceil nodes
        return new Node[] { floor, ceil };
    }

    private static Node findCeil(Node root, Node ceil, int key) {

        // If the root is null, simply return ceil(best candidate)
        if (root == null)
            return ceil;

        // If the value of root is >= key, update ceil to root and go left else go right
        return findCeil((root.data >= key ? root.left : root.right), (root.data >= key ? root : ceil), key);

    }

    private static Node findFloor(Node root, Node floor, int key) {

        // If the root is null, simply return floor(best candidate)
        if (root == null)
            return floor;

        // If the value of root is <= key, update floor to root and go right else left
        return findFloor((root.data <= key ? root.right : root.left), (root.data <= key ? root : floor), key);
    }
}
