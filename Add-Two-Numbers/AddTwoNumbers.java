public class AddTwoNumbers {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using dummy node and traversal
    public static Node addTwoNumbers(Node l1, Node l2) {

        // Dummy node for the final result LinkedList
        Node dummy = new Node(0, null);

        // Carry for the numbers
        int carry = 0;

        // Current node for the answer node
        Node current = dummy;

        // Reference nodes for both the lists
        Node t1 = l1, t2 = l2;

        // Traversal
        while (t1 != null || t2 != null) {

            // Get the values of the current node
            int x = (t1 != null) ? t1.data : 0;
            int y = (t2 != null) ? t2.data : 0;

            // Add the data and carry
            int sum = carry + x + y;

            // Set the next node of current with sum value
            current.next = new Node(sum % 10, null);

            // Update the carry for the next node
            carry = sum / 10;

            // Update the pointers for the list
            t1 = (t1 != null) ? t1.next : null;
            t2 = (t2 != null) ? t2.next : null;

            // Update the current pointer
            current = current.next;
        }

        // If the carry is still non zero, there is need of 1 extra node
        if (carry > 0)
            current.next = new Node(carry, null);

        // The answer head node would be next of the dummy node
        return dummy.next;
    }

}
