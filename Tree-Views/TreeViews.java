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

    // View-3 -> Right view of the tree
    public static List<Integer> rightView(Node root) {

        // Define a queue for a level order traversal
        Queue<Pair> queue = new LinkedList<>();

        // Define a hashmap for keeping track of the value and the level
        Map<Integer, Integer> map = new TreeMap<>();

        // Add the root node to the queue
        queue.add(new Pair(0, root));

        // Iterate until the queue is null
        while (!queue.isEmpty()) {

            // Get the current Pair
            Pair pair = queue.poll();
            Node node = pair.node;
            int level = pair.level;

            // Simply add to the map since the value required is last of that level
            map.put(level, node.data);

            // Add the left and right child of the node
            if (node.left != null)
                queue.add(new Pair(level + 1, node.left));
            if (node.right != null)
                queue.add(new Pair(level + 1, node.right));
        }

        // Return the values of map
        return new ArrayList<>(map.values());
    }

    // Variation-3 -> Right view of the tree using dfs
    public static List<Integer> rightViewDfs(Node root) {

        // if root is null, return empty list
        if (root == null)
            return List.of();

        // Define a list to store the values
        List<Integer> list = new ArrayList<>();

        // Perform dfs on the tree with right first traversal
        dfsRightView(root, 0, list);

        // Return the list
        return list;
    }

    // Dfs on the tree with right first traversal
    private static void dfsRightView(Node root, int level, List<Integer> list) {

        // If root is null, simply return
        if (root == null)
            return;

        // If the size of list is that of level, add the value to the list
        if (list.size() == level)
            list.add(root.data);

        // Go to right first to get the rightest node and right view
        dfsRightView(root.right, level + 1, list);

        // Go to left since right can be null and left would be in view
        dfsRightView(root.left, level + 1, list);
    }

    // View-4 -> Left view of tree
    public static List<Integer> leftView(Node root) {

        // Define a queue for a level order traversal
        Queue<Pair> queue = new LinkedList<>();

        // Define a hashmap for keeping track of the value and the level
        Map<Integer, Integer> map = new TreeMap<>();

        // Add the root node to the queue
        queue.add(new Pair(0, root));

        // Iterate until the queue is null
        while (!queue.isEmpty()) {

            // Get the current Pair
            Pair pair = queue.poll();
            Node node = pair.node;
            int level = pair.level;

            // Only add to the map if level is missing since first value is required
            map.putIfAbsent(level, node.data);

            // Add the left and right child of the node
            if (node.left != null)
                queue.add(new Pair(level + 1, node.left));
            if (node.right != null)
                queue.add(new Pair(level + 1, node.right));
        }

        // Return the values of map
        return new ArrayList<>(map.values());
    }

    // Variation-4 -> Left view of tree using dfs
    public static List<Integer> leftViewDfs(Node root) {

        // if root is null, return empty list
        if (root == null)
            return List.of();

        // Define a list to store the values
        List<Integer> list = new ArrayList<>();

        // Perform dfs on the tree with left first traversal
        dfsLeftView(root, 0, list);

        // Return the list
        return list;
    }

    // Dfs on the tree with left first traversal
    private static void dfsLeftView(Node root, int level, List<Integer> list) {

        // If root is null, simply return
        if (root == null)
            return;

        // If the size of list is that of level, add the value to the list
        if (list.size() == level)
            list.add(root.data);

        // Go to left first to get the leftest node and left view
        dfsLeftView(root.left, level + 1, list);

        // Go to right since left can be null and right would be in view
        dfsLeftView(root.right, level + 1, list);
    }

    // Reference Pair class
    public static class Pair {
        Node node;
        int level;

        public Pair(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }
}
