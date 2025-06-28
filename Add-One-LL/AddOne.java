public class AddOne {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using linkedlist reversal
    public static Node addOneReversal(Node head) {

        // Reverse the current linkedlist
        head = reverseList(head);

        // Add one using carry
        int carry = 1;
        Node current = head;

        // Traverse while the current list is not null
        while (current != null && carry > 0) {

            // First get current value and add carry
            int val = current.data + carry;

            // Update the data
            current.data = val % 10;

            // Update the carry
            carry = val / 10;

            // If current's next is null and there is still a carry
            if (carry > 0 && current.next == null) {
                current.next = new Node(carry, null);

                // Update the carry to 0
                carry = 0;
            }

            // Update the pointer
            current = current.next;
        }

        // Reverse the list again
        head = reverseList(head);

        // Finally return the head of the updated linkedlist
        return head;
    }

    private static Node reverseList(Node head) {

        // Helper nodes
        Node prev = null, current = head, next = null;

        // reversal
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Approach-2 -> Using recursion
    public static Node addOneRecursion(Node head) {

        // If head is null, return head
        if (head == null)
            return head;

        // Get the carry from util function
        int carry = addOneUtil(head);

        // If there is carry, there has to be another node
        if (carry > 0) {
            Node newNode = new Node(carry, head);
            head = newNode;
        }

        // Return the head of modified list
        return head;
    }

    private static int addOneUtil(Node node) {

        // If current node is null, return the carry as 1
        if (node == null)
            return 1;

        // Call for the next node
        int carry = addOneUtil(node.next);

        // Find the current addition
        int addition = node.data + carry;

        // Update the node value
        node.data = addition % 10;

        // Return the carry
        return addition / 10;
    }
}
