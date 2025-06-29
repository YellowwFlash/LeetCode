import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find {

    // Doubly linkedlist reference class
    static class Node {
        int data;
        Node next, prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }

    // Approach-1 -> Using two loops
    public static List<List<Integer>> findPairLoops(Node head, int x) {

        // If the head or its next is null, return null
        if (head == null || head.next == null)
            return null;

        // Result List
        List<List<Integer>> result = new ArrayList<>();

        // Reference node for the list reference
        Node ref = head;

        // Traverse until the ref's next is non null
        while (ref.next != null) {

            // Current node for finding the sum
            Node curr = ref.next;

            // Traverse until current is null and sum of current and ref is < x
            while (curr != null && (ref.data + curr.data) <= x) {

                // If the sum is equal to x, add it to list
                if (ref.data + curr.data == x)
                    result.add(Arrays.asList(ref.data, curr.data));

                // If not move the pointer
                curr = curr.next;
            }

            // Move the ref pointer
            ref = ref.next;
        }

        // Return the final result
        return result;
    }

    // Approach-2 -> Using two pointers
    public static List<List<Integer>> findPairsPointers(Node head, int x) {

        // If the head or its next is null, return null
        if (head == null || head.next == null)
            return null;

        // Result List
        List<List<Integer>> result = new ArrayList<>();

        // Make two pointers
        Node left = head;
        Node right = head;

        // Place right at the tail
        while (right.next != null)
            right = right.next;

        // Traverse until left != right
        while (left != right) {

            // If the value of left and right is x, add to list
            if (left.data + right.data == x) {
                result.add(Arrays.asList(left.data, right.data));

                // Move the left and right pointers
                left = left.next;
                right = right.prev;
            }

            // If the value of both exceeds sum, decrease right
            else if (left.data + right.data > x)
                right = right.prev;

            // If the value of both < sum, increase left
            else
                left = left.next;
        }

        // Return the final list
        return result;
    }
}
