public class RotateLL {

    // Linkedlist reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using the pointer tweakings
    public static Node rotate(Node head, int k) {

        // If head or head's next is null, return head
        if (head == null || head.next == null)
            return head;

        // Find the size of the Linkedlist
        int size = findSize(head);

        // Update k with in bounds of size
        k = k % size;

        // If k is equal to size, no rotation required
        if (k == size)
            return head;

        // Reference pointers for traversal
        Node current = head, ahead = head;

        // Place the ahead pointer k steps ahead
        for (int i = 0; i < k; i++)
            ahead = ahead.next;

        // Traverse the list until the next of ahead node is null
        while (ahead.next != null) {

            // Move the current and ahead pointer
            current = current.next;
            ahead = ahead.next;
        }

        // Change the reference of ahead to head
        ahead.next = head;

        // Assign the next of current as new head
        head = current.next;

        // Dereference the next of current node to null
        current.next = null;

        // Return the head of updated linked list
        return head;
    }

    private static int findSize(Node head) {

        // size to keep track of list size
        int size = 0;

        // Pointer to keep track of traversal
        Node current = head;

        // Size finding
        while (current != null) {

            // Increase the size first
            size++;

            // Move the pointer
            current = current.next;
        }

        // Return the size of the list
        return size;
    }
}
