public class LengthOfLoop {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using Floyd's Cycle Detection Algorithm
    public static int lengthOfLoop(Node head) {

        // Init the tortoise and hare
        Node slow = head, fast = head;

        // Traverse until fast or fast.next is not null
        while (fast != null && fast.next != null) {

            // Move tortoise
            slow = slow.next;

            // Move hare
            fast = fast.next.next;

            // If at any point tortoise and hare are equal, there is a cycle
            if (slow == fast) {

                // Find the length of loop
                Node temp = slow.next;
                int count = 1;

                while (temp != slow) {
                    temp = temp.next;
                    count++;
                }

                // Return the length
                return count;
            }
        }

        // Return 0 as there is no loop
        return 0;
    }
}
