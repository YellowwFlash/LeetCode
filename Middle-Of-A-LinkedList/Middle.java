public class Middle {

    // LinkedList reference class
    public static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Appraoch-1 -> Using the counting and finding technique
    public static int findMiddleCounting(Node head) {

        // Counter
        int count = 1;

        // Count total nodes in LinkedList
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Find the middle by finding the count / 2 th node
        int middle = (count / 2) + 1;
        count = 1;
        temp = head;

        // Traverse the list again to find the middle node
        while (count != middle) {
            count++;
            temp = temp.next;
        }

        // Return the value at current (middle) node
        return temp.data;
    }

    // Approach-2 -> Using Tortoise-Hare Algorithm
    public static int findMiddleTortoiseHare(Node head) {

        // Initialize two pointers, slow and fast
        Node slow = head, fast = head;

        // Move the list until either fast is null or its next is null
        while (fast != null && fast.next != null) {

            // Move slow by 1 node (tortoise)
            slow = slow.next;

            // Move fast by 2 nodes (hare)
            fast = fast.next.next;
        }

        // Return the slow pointer's data as middle node
        return slow.data;
    }
}
