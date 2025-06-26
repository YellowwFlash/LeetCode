public class SortLL {

    // Ḷinkedlist reference class
    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using merge sort
    public static Node sortLL(Node head) {

        // If head or head.next is null, return head
        if (head == null || head.next == null)
            return head;

        // Find the middle Node
        Node middle = getMiddle(head);

        // Set the head of left and right list
        Node left = head;
        Node right = middle.next;
        // Set the middle node's next to null
        middle.next = null;

        // Recursively sort the left part
        left = sortLL(left);

        // Recursively sort the right part
        right = sortLL(right);

        // Return the merge of both of them
        return mergeLists(left, right);
    }

    private static Node getMiddle(Node head) {

        // Define tortoise and hare
        Node slow = head, fast = head;

        // Tortoise-Hare algorithm
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node mergeLists(Node left, Node right) {

        // Dummy node for referencing
        Node dummy = new Node(0, null);
        // Current node for traversal
        Node current = dummy;

        // Apply merging on both of the lists
        while (left != null && right != null) {

            // Check if data at left is less than data at right
            if (left.data < right.data) {

                // The next of the current node will be left
                current.next = left;

                // Move the left pointer
                left = left.next;
            }

            // If not, then the next of current will be right
            else {
                current.next = right;

                // Move the right pointer
                right = right.next;
            }

            // Move the current pointer
            current = current.next;
        }

        // Check if any of the list is non null
        if (left != null)
            current.next = left;

        if (right != null)
            current.next = right;

        // Return the dummy's next node as the new head of sorted list
        return dummy.next;
    }
}
