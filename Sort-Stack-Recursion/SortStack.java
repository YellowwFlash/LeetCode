import java.util.Stack;

public class SortStack {

    // Approach-1 -> Using recursion
    public static Stack<Integer> sortStack(Stack<Integer> stack) {

        // If the stack is empty or has size 1, its already sorted
        if (stack.isEmpty() || stack.size() == 1)
            return stack;

        // Get the top element
        int top = stack.pop();
        // Recursively sort the remaining stack
        sortStack(stack);
        // Insert the element that has been popped
        insert(stack, top);

        // Return the sorted stack
        return stack;
    }

    private static void insert(Stack<Integer> stack, int top) {

        // If the stack is empty or the element at top <= current top
        if (stack.isEmpty() || stack.peek() <= top) {

            // Insert the current top and return
            stack.push(top);
            return;
        }

        // If not, find the position for the element to be placed
        int element = stack.pop();

        // Find the right position
        insert(stack, top);

        // Insert the element back in stack
        stack.push(element);
    }
}
