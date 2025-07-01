public class RemoveNthNode {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using size count
    public static Node removeKthFromEndSize(Node head, int k) {

        // If head is null, return
        if (head == null)
            return head;

        // Start the traversal from head
        Node temp = head;

        // Size for finding the length of LinkedList
        int size = 0;

        while (temp != null) {

            // Increase the size
            size++;

            // Move the pointer
            temp = temp.next;
        }

        if (k == size)
            return head.next;

        // For kth node from end, one should be at n-k th node from Start
        int reference = 1;
        temp = head;

        while (reference != size - k) {
            // Move the pointer
            temp = temp.next;
            // Increase the reference counter
            reference++;
        }

        // Being at the n-k th node, remove the next node
        temp.next = temp.next.next;

        return head;
    }

    // Approach-2 -> Using the distance technique
    public static Node removeKthFromEndDistance(Node head, int k) {

        // If head is null, return
        if (head == null)
            return head;

        // Dummy node since k can be pointing to head
        Node dummy = new Node(0, head);

        // Define two pointers, 1 normal and 1 at k distance from start
        Node slow = dummy, fast = dummy;

        // Place fast node at k+1 distance from start
        for (int i = 0; i <= k; i++) {

            // If fast is null, return head since k > size of LinkedList
            if (fast == null)
                return head;

            fast = fast.next;
        }

        // Now traverse using the slow and fast pointers
        while (fast != null) {
            // Move the slow pointer
            slow = slow.next;
            // Move the fast pointer
            fast = fast.next;
        }

        // Slow will be at k+1 th node from end, so remove kth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
