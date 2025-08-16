import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

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

    // Approach-1 -> Using level order traversal
    public static String serialize(Node root) {

        // If root is null, return an empty string
        if (root == null)
            return "";

        // Define result string
        StringBuilder result = new StringBuilder();

        // Define queue for level order traversal
        Queue<Node> queue = new LinkedList<>();

        // Add root to queue
        queue.add(root);

        // Iterate the whole tree
        while (!queue.isEmpty()) {

            // Get the current level
            int level = queue.size();

            // Iterate the current level
            for (int i = 0; i < level; i++) {

                // Get the current node
                Node node = queue.poll();

                result.append(node == null ? "# " : node.data + " ");

                // Add left and right child to queue
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        // Return the result string as serialized string
        return result.toString();
    }

    // Deserialization of string
    public static Node deserialize(String data) {

        // If the string is empty, return null
        if (data == null || data.isEmpty())
            return null;

        // Convert the string into array using spaces
        String[] nodes = data.split(" ");

        // Define a queue for conversion of traversal
        Queue<Node> queue = new LinkedList<>();

        // Create root node
        Node root = new Node(Integer.parseInt(nodes[0]));

        // Add the root node in queue
        queue.add(root);

        // Traverse through all the nodes
        for (int i = 1; i < nodes.length; i++) {

            // Get the current node
            Node node = queue.poll();
            String current = nodes[i];
            String next = nodes[++i];

            // First set the left of the current node
            if (!current.equals("#")) {
                Node left = new Node(Integer.parseInt(current));

                // Set the left of current node to left
                node.left = left;

                // Add the left node in queue
                queue.add(left);
            }

            // Set the right of the current node
            if (!next.equals("#")) {

                Node right = new Node(Integer.parseInt(next));

                // Set the right of current node to right
                node.right = right;

                // Add the right node in queue
                queue.add(right);
            }
        }

        // Return the root of the new tree
        return root;
    }
}
