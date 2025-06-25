public class DetectCycle {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using Tortoise Hare algorithm
    public static boolean detectCycle(Node head) {

        // Initialize slow and fast pointers
        Node slow = head, fast = head;

        // Traverse the list until the tortoise(slow) equals hare(fast)
        while (fast != null && fast.next != null) {

            // Move the tortoise
            slow = slow.next;

            // Move the hare
            fast = fast.next.next;

            // If at any point, they are equal, there is a cycle
            if (slow == fast)
                return true;
        }

        // Return false as there is no cycle
        return false;
    }

    // Approach-1 -> Extension if start of the cycle is required
    public static Node detectCycleStart(Node head) {

        // Initialize slow and fast pointers
        Node slow = head, fast = head;

        // Traverse the list until the tortoise(slow) equals hare(fast)
        while (fast != null && fast.next != null) {

            // Move the tortoise
            slow = slow.next;

            // Move the hare
            fast = fast.next.next;

            // If at any point, they are equal, there is a cycle
            if (slow == fast) {
                // Reset the fast pointer to head and keep the slow pointer at the meeting point
                Node temp1 = head;
                Node temp2 = slow;

                // Until temp1 and temp2 are not equal traverse the list
                while (temp1 != temp2) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }

                // Return the temp1 pointer as start of the cycle
                return temp1;
            }
        }

        // Return null as there is no cycle
        return null;
    }
}
