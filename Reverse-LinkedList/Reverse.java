import java.util.Stack;

public class Reverse {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using stack and new linkedlist
    public static Node reverseUsingStack(Node head) {

        // Stack to keep the nodes in reverse order
        Stack<Integer> stack = new Stack<>();

        // Temp node for reference
        Node temp = head;

        // Traversal for node values
        while (temp != null)

            // Add the value of temp node in stack
            stack.push(temp.data);

        // Create a new linkedlist
        Node newHead = new Node(stack.pop(), null);
        temp = newHead;

        // Traverse the stack to make the new linkedlist
        while (!stack.isEmpty()) {

            // Create a new node
            temp.next = new Node(stack.pop(), null);

            // Move temp by 1 pointer
            temp = temp.next;
        }

        // Return the head of the new linkedlist
        return newHead;
    }

    // Approach-2 -> Using previous, current and next pointers
    public static Node reverseUsingPointers(Node head) {

        // Pointers for the reference
        Node prev = null, current = head, next = null;

        // Loop until the current pointer is null
        while (current != null) {

            // Set the next pointer to current.next
            next = current.next;
            // Set the current.next as prev
            current.next = prev;
            // Move prev to current
            prev = current;
            // Move current to next
            current = next;
        }

        // Since prev will be the pointer at tail, itll be new head
        return prev;
    }

    // Approach-3 -> Using recursion
    public static Node reverseUsingRecursion(Node head) {

        // If the current head is null or the next of head is null, return head
        if (head == null || head.next == null)
            return head;

        // Call the next node and find new head
        Node newHead = reverseUsingRecursion(head.next);
        // Next node to reverse the linkedlist
        Node front = head.next;

        // Next of front will be head
        front.next = head;

        // Next of head will be null
        head.next = null;

        // Return the new head
        return newHead;
    }
}
