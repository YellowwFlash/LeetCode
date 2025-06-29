public class RemoveDuplicates {

    // Doubly linkedlist reference class
    static class Node {
        int data;
        Node next, prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // Approach-1 -> Using pointer tweakings
    public static Node removeDuplicates(Node head) {

        // If head or its next is null, return null
        if (head == null || head.next == null)
            return head;

        // Current traversal Node
        Node current = head;

        // Traversal for duplicates removal
        while (current.next != null) {

            // Ref node for finding the non duplicate node
            Node ref = current.next;

            // Skip all the duplicates
            while (ref != null && current.data == ref.data)
                // Move the ref to next point
                ref = ref.next;

            // Channge the next of current node to non duplicate node
            current.next = ref;
            // Change ref's prev to current
            if (ref != null)
                ref.prev = current;

            // Move the current node
            current = current.next;
        }

        // Finally return the updated head of the list
        return head;
    }
}
