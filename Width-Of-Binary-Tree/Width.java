import java.util.LinkedList;
import java.util.Queue;

public class Width {

    // Reference Node class for tree
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Reference class Pair for pair of node and index
    public static class Pair {
        Node node;
        int index;

        public Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Approach-1 -> Using index management
    public static int width(Node root) {

        // If root is null, simply return 0
        if (root == null)
            return 0;

        // Define queue to store pairs
        Queue<Pair> q = new LinkedList<>();

        // Add the root node with index 0
        q.add(new Pair(root, 0));

        // Define width to keep track of the maximum width
        int width = 0;

        // Iterate while the queue is not empty
        while (!q.isEmpty()) {

            // Get the current level using size of the queue
            int level = q.size();

            // Get the node value and index
            int index = q.peek().index, first = 0, last = 0;

            // Add all the nodes of current level
            for (int i = 0; i < level; i++) {

                // Remove the current pair
                Pair pair = q.poll();

                // Find current index
                int currentIndex = pair.index - index;

                // Set first and last according to the first and last of levels
                if (i == 0)
                    first = currentIndex;

                if (i == level - 1)
                    last = currentIndex;

                // Add left and right childs into queue
                if (pair.node.left != null)
                    q.add(new Pair(pair.node.left, currentIndex * 2 + 1));

                if (pair.node.right != null)
                    q.add(new Pair(pair.node.right, currentIndex * 2 + 2));
            }

            // Find the max of width
            width = Math.max(width, last - first + 1);
        }

        // Return width as the final result
        return width;
    }
}
