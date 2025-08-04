import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeViews {

    // Reference Node class for tree
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

    // View-1 -> Top view of the tree
    public static List<Integer> topView(Node root) {

        // If root is null, return empty list
        if (root == null)
            return List.of();

        // Define a hashmap to keep track of column and values
        Map<Integer, Integer> map = new TreeMap<>();

        // Define a queue for a level order traversal
        Queue<Tuple> queue = new LinkedList<>();

        // Add root node to queue
        queue.add(new Tuple(root, 0));

        // Iterate until the queue is empty

        while (!queue.isEmpty()) {

            // Get the current tuple
            Tuple tuple = queue.poll();

            // If the column is not in the map, add it
            if (!map.containsKey(tuple.column))
                map.put(tuple.column, tuple.node.data);

            // If the left child exists, add it to the queue
            if (tuple.node.left != null)
                queue.add(new Tuple(tuple.node.left, tuple.column - 1));

            // If the right child exists, add it to the queue
            if (tuple.node.right != null)
                queue.add(new Tuple(tuple.node.right, tuple.column + 1));
        }

        // Return the list of all the values of map
        return new ArrayList<>(map.values());
    }

    // View-2 -> Bottom view of the tree
    public static List<Integer> bottomView(Node root) {

        // If root is null, return empty list
        if (root == null)
            return List.of();

        // Define a hashmap to keep track of column and values
        Map<Integer, Integer> map = new TreeMap<>();

        // Define a queue for a level order traversal
        Queue<Tuple> queue = new LinkedList<>();

        // Add root node to queue
        queue.add(new Tuple(root, 0));

        // Iterate until the queue is empty

        while (!queue.isEmpty()) {

            // Get the current tuple
            Tuple tuple = queue.poll();

            // Add the value to the map and overwrite to get the last seen value(bottom)
            map.put(tuple.column, tuple.node.data);

            // If the left child exists, add it to the queue
            if (tuple.node.left != null)
                queue.add(new Tuple(tuple.node.left, tuple.column - 1));

            // If the right child exists, add it to the queue
            if (tuple.node.right != null)
                queue.add(new Tuple(tuple.node.right, tuple.column + 1));
        }

        // Return the list of all the values of map
        return new ArrayList<>(map.values());
    }

    // Reference Tuple class
    public static class Tuple {
        Node node;
        int column;

        Tuple(Node node, int column) {
            this.node = node;
            this.column = column;
        }
    }
}
