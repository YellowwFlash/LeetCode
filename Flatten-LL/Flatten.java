import java.util.ArrayList;
import java.util.Collections;

public class Flatten {

    // Linkedlist reference class
    static class Node {
        int data;
        Node next, child;

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }

    // Approach-1 -> Using a new linked list and sorting
    public static Node flattenSorting(Node head) {

        // If head or its next is null, return head
        if (head == null || head.next == null)
            return head;

        // List to store all the nodes
        ArrayList<Integer> list = new ArrayList<>();

        // Current pointer for traversal
        Node current = head;

        while (current != null) {

            // Reference pointer for child nodes traversal
            Node child = current;

            // Traversal until the child is non null
            while (child != null) {

                // Add the value of child node in list
                list.add(child.data);

                // Move the pointer to next child
                child = child.child;
            }

            // Ṃove the current pointer
            current = current.next;
        }

        // Sort the given list
        Collections.sort(list);

        // Create a new node and child nodes for sorted list
        Node newHead = new Node(list.get(0), null, null);

        // Set the current node to newHead
        Node currentNew = newHead;

        for (int data : list) {

            // Create a new node for the child
            currentNew.child = new Node(data, null, null);

            // Move the current node to the child
            currentNew = currentNew.child;
        }

        // Make newHead as the new updated head and return it
        return newHead;
    }

    // Approach-2 -> Using merge sort and recursion
    public static Node flattenRecursion(Node head) {

        // if the head is null, simply return null
        if (head == null) {
            return null;
        }

        // If the next of head is null, return the head
        if (head.next == null) {
            return head;
        }

        return merge(head, flattenRecursion(head.next));
    }

    private static Node merge(Node l1, Node l2) {

        // Dummy node to keep track of the head of merged list
        Node dummy = new Node(0, null, null);

        // Current node to keep adding the new nodes
        Node current = dummy;

        // Merging using shared traversal
        while (l1 != null && l2 != null) {

            // If data at l1 < l2, l1 comes first
            if (l1.data < l2.data) {

                // Assign the child of current as l1
                current.child = l1;

                // Move l1 pointer to its child
                l1 = l1.child;
            }

            // If not, l2 comes first
            else {

                // Assign child of current as l2
                current.child = l2;

                // Move l2 pointer to its child
                l2 = l2.child;
            }

            // Set the current pointer's next to null
            current.next = null;

            // Move the current pointer to its child
            current = current.child;
        }

        // Add the remaining lists
        if (l1 != null)
            current.child = l1;
        else
            current.child = l2;

        // Return dummy's child as the head of updated list
        return dummy.child;
    }
}
