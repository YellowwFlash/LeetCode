public class Clone {

    // Linkedlist reference class
    public static class Node {
        public int data;
        public Node next, random;

        Node(int data, Node next, Node random) {
            this.data = data;
            this.next = next;
            this.random = random;
        }
    }

    // Approach-1 -> Using the list iteself
    public static Node cloneList(Node head) {

        // First add copy between nodes
        addCopyBetweenNodes(head);

        // Align the random pointers
        alignRandomPointers(head);

        // Finally return the seprated list
        return separateList(head);
    }

    private static Node separateList(Node head) {

        // Dummy node to keep track of the new copied list
        Node dummy = new Node(0, null, null);
        Node ref = dummy;

        Node current = head;

        while (current != null) {

            // first set the next of ref node as current's next
            ref.next = current.next;

            // Set current's next to current's next's next
            current.next = current.next == null ? null : current.next.next;

            // Move the ref to its next
            ref = ref.next;

            // Move current to its next
            current = current.next;
        }

        // Return the next of dummy as the new head of copied list
        return dummy.next;
    }

    private static void alignRandomPointers(Node head) {

        // Current node for traversal
        Node current = head;

        while (current != null) {

            // Find the random connection
            Node random = current.random;

            // Set the random node of copy node
            current.next.random = random == null ? null : random.next;

            // Move current by two pointers
            current = current.next.next;
        }
    }

    private static void addCopyBetweenNodes(Node head) {

        // Current node for traversal
        Node current = head;

        while (current != null) {

            // Make a copy node for copying the current node
            Node copy = new Node(current.data, null, null);

            // Set copy node's next to current's next
            copy.next = current.next;

            // Set copy node as next of current
            current.next = copy;

            // Move the current by two pointers
            current = copy.next;
        }
    }
}
