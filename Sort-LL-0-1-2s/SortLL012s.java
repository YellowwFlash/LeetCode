public class SortLL012s {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> By chagining the links
    public static Node sort(Node head) {

        // If head or head's next is null, return head
        if (head == null || head.next == null)
            return head;

        // Pointers for 0,1 and 2 respectievely
        Node zero = null, one = null, two = null;

        // Head reference of one and two
        Node headZero = null, headOne = null, headTwo = null;

        // Current node for traversal
        Node current = head;

        // Traverse the whole LinkedList
        while (current != null) {

            // If current node is zero, init the zero node
            if (current.data == 0) {

                // If the zero pointer is not init, first init
                if (zero == null) {
                    zero = current;

                    // Init the head of the zero node
                    headZero = zero;
                }

                // If not, simply point zero to current node
                else
                    zero.next = current;
            }

            // If the current node is one, init the one node
            else if (current.data == 1) {

                // If the one pointer is not init, first init
                if (one == null) {
                    one = current;

                    // Init the head of one node also
                    headOne = one;
                }

                // If not, simply point one to current node
                else
                    one.next = current;
            }

            // If the current node is two, init the two node
            else {
                // If the two pointer is not init, first init
                if (two == null) {
                    two = current;

                    // Init the head of two node also
                    headTwo = two;
                }

                // If not, simply point two to current node
                else
                    two.next = current;
            }

            // Finally move the current pointer
            current = current.next;
        }

        // Link the heads
        zero.next = headOne;

        // Check for one not null
        if (one != null)
            one.next = headTwo;

        // Check for two not null
        if (two != null)
            two.next = null;

        // If headzero is not null return headzero else headone else headTwo
        return headZero != null ? headZero : headOne != null ? headOne : headTwo;
    }
}