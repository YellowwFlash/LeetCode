import java.util.Stack;

public class ReverseStack {

    // Approach-1 -> Using recursion
    public static void reverseStack(Stack<Integer> stack) {

        // if the size of the stack is 1 or its empty, its already reversed
        if (stack.size() <= 1)
            return;

        // Get the top element
        int element = stack.pop();

        // Recursively reverse the rest of the elements
        reverseStack(stack);

        // Insert the current element in stack
        insertAtBottom(stack, element);

        // Return after the insertion
        return;
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {

        // If the stack is empty, insert the current element and return
        if (stack.isEmpty()) {

            // Insert the current element
            stack.push(element);

            // Return from this
            return;
        }

        // Get the top element
        int top = stack.pop();

        // Recursively insert at the bottom of the stack
        insertAtBottom(stack, element);

        // Insert the top back in the stack
        stack.push(top);
    }
}
