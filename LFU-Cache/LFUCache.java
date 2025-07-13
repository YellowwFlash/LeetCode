import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    // Reference class for the LFU cache
    private class Node {
        int key;
        int value;
        int frequency;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // Initial frequency is 1
            this.prev = null;
            this.next = null;
        }
    }

    private class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    private Map<Integer, Node> nodeMap; // Maps key to Node
    private Map<Integer, DoublyLinkedList> frequencyMap; // Maps frequency to list of

    private int minFrequency; // Minimum frequency of any node in the cache
    private int capacity; // Maximum capacity of the cache
    private int currentSize; // Current size of the cache

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.minFrequency = 0;
        this.nodeMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1; // Key not found
        }

        Node node = nodeMap.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {

        // If the capactiy is zero, do nothing
        if (capacity == 0)
            return;

        // If the key already exists, update its value and frequency
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateNode(node);
        }

        // If not start with scratch
        else {

            // Increase the size first
            currentSize++;

            // Check if the cache is at capacity
            if (currentSize > capacity) {

                // Get the list with minimum frequency
                DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);

                // Remove the least frequently used node
                nodeMap.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);

                // Reduce the size
                currentSize--;
            }

            // Set the min frequency to 1
            minFrequency = 1;

            // Create a new node and add it to the node map
            Node newNode = new Node(key, value);

            // Get the list for frequency 1, or create a new one if it doesn't exist
            DoublyLinkedList freqList = frequencyMap.getOrDefault(1, new DoublyLinkedList());
            freqList.addNode(newNode);

            frequencyMap.put(1, freqList);
            nodeMap.put(key, newNode);
        }
    }

    private void updateNode(Node node) {

        // Get frequency of the node
        int currentFrequency = node.frequency;

        // Get the current list for that frequency
        DoublyLinkedList currentList = frequencyMap.get(currentFrequency);

        // Remove the node from the current frequency list
        currentList.removeNode(node);

        // If the current frequency is equal to minimum frequency and the list is empty,
        if (currentList.size == 0 && currentFrequency == minFrequency) {
            minFrequency++; // Increase the minimum frequency
        }
        
        // Increase the frequency of the node
        node.frequency++;

        // Add the node to the next frequency list
        DoublyLinkedList nextList = frequencyMap.getOrDefault(node.frequency, new DoublyLinkedList());
        nextList.addNode(node);
        frequencyMap.put(node.frequency, nextList);
    }
}
