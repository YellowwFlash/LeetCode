public class ReverseNodes {

    // Linkedlist reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;

        }
    }

    // Approach-1 -> Using the pointers and reversal
    public static Node reverseNodes(Node head, int k) {

        // If head or its next is null, return head
        if (head == null || head.next == null)
            return head;

        // Get the reference nodes for traversal
        Node current = head, previous = null;

        // Traversal
        while (current != null) {

            // Find the kth node first
            Node kthNode = findKthNode(current, k);

            // Find if the kth node is null, then just join the rest
            if (kthNode == null) {

                // If the previous node is non null, join it to current
                if (previous != null)
                    previous.next = current;

                // Since this is the end, break the loop
                break;
            }

            // Store the next node first
            Node next = kthNode.next;

            // Set the next of kth node to null for efficient reversal
            kthNode.next = null;

            // Reverse the list
            reverse(current);

            // For current being head, update the new head
            if (current == head)
                head = kthNode;

            // If not, then link the previous node with current kth node
            else
                previous.next = kthNode;

            // Update the previous node
            previous = current;

            // Move the current node
            current = next;
        }

        // Return the head of the updated list
        return head;
    }

    private static Node findKthNode(Node head, int k) {

        // Reference node for traversal
        Node current = head;

        // Reduce k first since the traveral is already started from 1st node
        k--;

        // Traversal until the k is non zero
        while (current != null && k > 0) {

            // Decrease the k
            k--;

            // Move the pointer
            current = current.next;
        }

        // Even with null, returning current will handle the case
        return current;
    }

    private static Node reverse(Node head) {

        // Get the pointers
        Node prev = null, current = head, next = null;

        // Reversal of the list
        while (current != null) {
            // Store the next node
            next = current.next;
            // Reverse the link
            current.next = prev;
            // Store the prev node
            prev = current;
            // Move the current node
            current = next;
        }

        // Return the prev node as new head
        return prev;
    }
}
