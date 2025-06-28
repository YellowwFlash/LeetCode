import java.util.HashMap;

public class Intersection {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using hashmap
    public static Node findIntersectionHashMap(Node head1, Node head2) {

        // If any of the heads are null, return null
        if (head1 == null || head2 == null)
            return null;

        // Hashmap to keep track of the nodes
        HashMap<Node, Integer> map = new HashMap<>();

        // Traverse the nodes of list1
        Node current1 = head1;

        while (current1 != null) {

            // Add the current node to map
            map.put(current1, 1);

            // Move the current pointer
            current1 = current1.next;
        }

        // Traverse the nodes of list2
        Node current2 = head2;

        while (current2 != null) {

            // Check if the current node already exists in map
            if (map.containsKey(current2)) {
                // Return the current node since its the intersection
                return current2;
            }

            // If not, add the current node in map
            map.put(current2, 1);

            // Move the current pointer
            current2 = current2.next;
        }

        // Return null since there is no intersection
        return null;
    }

    // Approach-2 -> Using the size technique
    public static Node findIntersectionSize(Node head1, Node head2) {

        // If any of the heads are null, return null
        if (head1 == null || head2 == null)
            return null;

        // Find the size of both the lists
        int size1 = findSize(head1);
        int size2 = findSize(head2);

        // Find which has greater size to reset the pointer
        Node larger = (size1 > size2) ? head1 : head2;
        Node smaller = (size1 > size2) ? head2 : head1;

        // Find the difference and place larger node at that difference
        int diff = Math.abs(size1 - size2);

        // Place the larger node at the difference
        for (int i = 0; i < diff; i++)
            larger = larger.next;

        // Traverse both lists simultaneously to find the common node
        while (larger != null) {

            // If both the nodes are same, return the node
            if (larger == smaller)
                return larger;

            // If not move the pointers
            larger = larger.next;
            smaller = smaller.next;
        }

        // Return null since there is no intersection
        return null;
    }

    private static int findSize(Node head) {

        // Size of the list
        int size = 0;

        // Current node for traversal
        Node current = head;

        while (current != null) {

            // Increase the size
            size++;

            // Move the current pointer
            current = current.next;
        }

        return size;
    }

    // Approach-3 -> Using pointers technique
    public static Node findIntersection(Node head1, Node head2) {

        // If any of the heads are null, return null
        if (head1 == null || head2 == null)
            return null;

        // Define two pointers for simultaneously traversing lists
        Node current1 = head1, current2 = head2;

        // Traverse while both of them doesnt point to null
        while (current1 != current2) {

            // If current1 is null, reinit it to head2 else move
            current1 = (current1 != null) ? current1.next : head2;

            // If current2 is null, reinit it to head1 else move
            current2 = (current2 != null) ? current2.next : head1;
        }

        // Return current1 as point of intersection
        return current1;
    }
}
