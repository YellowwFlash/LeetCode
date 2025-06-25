import java.util.Stack;

public class Palindrome {

    // LinkedList reference class
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Approach-1 -> Using stack and two pointers
    public static boolean isPalindromeStack(Node head) {

        // Stack for storing all the node values
        Stack<Integer> stack = new Stack<>();

        // Add all the nodes in the stack
        Node temp = head;

        while (temp != null) {

            // Add in stack
            stack.push(temp.data);
            // Move the pointer
            temp = temp.next;
        }

        // Reset the pointer to head
        temp = head;

        // Traverse the stack and list to find palindrome
        while (temp != null)

            // If at any point, value of stack is not equal to node val, return false
            if (stack.pop() != temp.data)
                return false;

            // If not, move the pointer
            else
                temp = temp.next;

        // Return true since the list is palindrome
        return true;
    }

    // Approach-2 -> Using Tortoise-Hare Algorithm
    public static boolean isPalindromeTortoiseHare(Node head) {

        // If the list is empty, return true
        if (head == null)
            return true;

        // Init slow and fast pointers
        Node slow = head, fast = head;

        // Traverse till the middle of the list(m1 for even length)
        while (fast.next != null && fast.next.next != null) {

            // move the Tortoise
            slow = slow.next;

            // move the Hare
            fast = fast.next.next;
        }

        // Reverse the list from slow.next till the end
        Node prev = null, current = slow.next, next = null;

        // Until the current is not null, reverse it
        while (current != null) {

            // Define next node
            next = current.next;
            // Reverse the current node
            current.next = prev;
            // Move the prev pointer
            prev = current;
            // Move the current pointer
            current = next;
        }

        // Starting from prev and starting from head, start compairison
        Node left = head, right = prev;

        while (right != null) {
            // If not equal, return false
            if (left.data != right.data)
                return false;

            // Move the left pointer
            left = left.next;
            // Move the right pointer
            right = right.next;
        }

        // Reverse the list again after the slow pointer for same list  

        // Return true since the list is palindrome
        return true;
    }
}
