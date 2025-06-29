public class Remove {

    // Doubly Linkedlist reference class
    static class Node {
        int data;
        Node next, prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // Approach-1 -> Using pointers
    public static Node remove(Node head, int key) {

        // If head is null, return null
        if (head == null)
            return null;

        if (head.next == null && head.data == key)
            return null;

        // Current reference node for traversal
        Node current = head;

        // Until the current is not null
        while (current != null) {

            // If current node's data is equal to key
            if (current.data == key) {

                // If current is head, simply move the head
                if (current == head) {

                    // Move the head
                    head = current.next;

                    // Set prev of head to null if head is non null
                    if (head != null)
                        head.prev = null;
                }

                // If not, the node is somewhere after head
                else {

                    // Find the next and prev node
                    Node nextNode = current.next, prevNode = current.prev;

                    // If prev node is not null, set its next to current.next
                    if (prevNode != null)
                        prevNode.next = nextNode;

                    // If next node is not null, set its prev to current.prev
                    if (nextNode != null)
                        nextNode.prev = prevNode;
                }
            }

            // Move the current pointer
            current = current.next;
        }

        // Finally return the head of the modified list
        return head;
    }
}