import java.util.Map;

public class LRUCache {

    // Node class to represent doubly linked list nodes
    private static class Node {
        int key, data;
        Node prev, next;

        Node(int key, int data) {
            this.key = key;
            this.data = data;
        }

        Node(int key, int data, Node prev, Node next) {
            this.key = key;
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Define a doubly linked list to maintain the order of nodes
    private Node head, tail;

    // HashMap to store key and corresponding node
    private Map<Integer, Node> map;

    // Maximum capacity of the cache
    private int capacity;

    // Lru cache constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new java.util.HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        this.head.next = tail; // Initialize head's next to tail
        this.tail.prev = head; // Initialize tail's prev to head
    }

    // Delete node from the cache
    private void deleteNode(Node node) {
        // Remove the node from the map
        map.remove(node.key);

        // Adjust pointers to remove the node from the linked list
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    // Add node to the front of the cache
    private void addNode(Node node) {
        // Add the node to the map
        map.put(node.key, node);

        // Adjust pointers to add the node at the front (head) of the list
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Get key from cache
    public int get(int key) {

        // If key is not present, return -1
        if (!map.containsKey(key))
            return -1;

        // Get the node from the map
        Node node = map.get(key);

        deleteNode(node); // Remove the node from its current position
        addNode(node); // Add the node to the front (head) of the list

        // Return the value of the node
        return node.data;
    }

    // Put key-value pair in cache
    public void put(int key, int value) {

        // If the node is already present, update its value and move it to the front
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.data = value; // Update the value
            deleteNode(node); // Remove the node from its current position
            addNode(node); // Add the updated node to the front (head) of the list
        } else {
            // If the cache is at capacity, remove the least recently used (tail) node
            if (map.size() == capacity)
                deleteNode(tail.prev); // Remove the last node before tail

            // Create a new node and add it to the front of the cache
            Node newNode = new Node(key, value);
            addNode(newNode);
        }
    }
}
