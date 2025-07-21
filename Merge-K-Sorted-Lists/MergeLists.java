import java.util.PriorityQueue;

public class MergeLists {

    // LinkedList referece class
    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using Priority Queue
    public static Node mergeLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head of each list to the min heap
        for (Node list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        Node dummy = new Node(0, null);
        Node current = dummy;

        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            // If there is a next node, add it to the heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }
}