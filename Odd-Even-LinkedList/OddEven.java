import java.util.ArrayList;

public class OddEven {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using arraylists
    public static void oddEvenUsingArrayLists(Node head) {

        // If list is one noded or null, return
        if (head == null || head.next == null)
            return;

        // Two arraylists for odd and even nodes storage
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        // Traverse the list for node storage
        Node temp = head;
        int count = 1;

        while (temp != null) {

            // Find whether the node is even or odd and add accordingly
            if (count % 2 == 1)
                odd.add(temp.data);
            else
                even.add(temp.data);

            // Increase the count
            count++;
            // Move the pointer
            temp = temp.next;
        }

        // Since odd nodes will be first, add all the odd nodes
        temp = head;
        int index = 0;

        while (index < odd.size()) {

            // Replace the value of temp node with odd value node
            temp.data = odd.get(index++);

            // Move the temp pointer
            temp = temp.next;
        }

        // Add even valued nodes in the remaining list
        index = 0;

        while (index < even.size()) {

            // Replace the value of temp node with even value node
            temp.data = even.get(index++);

            // Move the temp pointer
            temp = temp.next;
        }
    }

    // Approach-2 -> Using simple pointer movements
    public static void oddEvenUsingPointers(Node head) {

        // If list is null or single noded, return
        if (head == null || head.next == null)
            return;

        // Make two pointers for even and odd nodes
        Node odd = head, even = head.next;

        // Reference pointer for even node
        Node referenceEven = head.next;

        // Traverse the list until the even node is not null
        while (even != null && even.next != null) {

            // Since the first one is odd node, make changes
            odd.next = even.next;
            // Move the odd pointer 
            odd = odd.next;

            // Second is the even node, make changes
            even.next = odd.next;
            // Move the even pointer
            even = even.next;
        }

        // Point the odd's next node to referenceEven
        odd.next = referenceEven;
    }
}