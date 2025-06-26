public class Delete {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using Tortoise-Hare algorithm
    public static Node deleteNode(Node head) {

        // If head is null or head's next is null, return null
        if (head == null || head.next == null)
            return null;

        // Define slow and fast pointers
        Node slow = head, fast = head;

        // Tortoise-hare algorithm
        while (fast.next != null && fast.next.next != null) {

            // Move the slow pointer
            slow = slow.next;

            // Move the fast pointer
            fast = fast.next.next;
        }

        // For odd length, if fast.next is null, change values first
        if (fast.next == null)
            slow.data = slow.next.data;

        // Remove the middle Node
        slow.next = slow.next.next;

        // Return the head
        return head;
    }
}
