import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater {

    // Approach-1 -> Using regular traversal
    public static int[] nextGreaterElement(int nums[], int subset[]) {

        // Find the lengths
        int n = nums.length, m = subset.length;

        // Define nge array
        int[] nge = new int[n];

        // Fill the nge array with -1
        Arrays.fill(nge, -1);

        // Start the traversal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    nge[i] = nums[j];
                    break;
                }
            }
        }

        // Define result array
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int current = subset[i];

            for (int j = 0; j < n; j++)
                if (nums[j] == current) {
                    result[i] = nge[j];
                    break;
                }
        }

        // Return the final result
        return result;
    }

    // Approach-2 -> Using stack and Hashmap
    public static int[] nextGreaterElementStack(int nums[], int subset[]) {

        // Find the lengths
        int n = nums.length, m = subset.length;

        // Map to keep track of the next greater element
        Map<Integer, Integer> map = new HashMap<>();

        // Stack for keeping track of the greater element
        Stack<Integer> stack = new Stack<>();

        // Traverse from backward
        for (int i = n - 1; i >= 0; i--) {

            int current = nums[i];

            // Remove from stack until a greater element is found
            while (!stack.isEmpty() && current >= stack.peek())
                stack.pop();

            // If stack is empty, there is no next greater else the element at top
            map.put(current, stack.isEmpty() ? -1 : stack.peek());

            // Add the current element in stack for next elemetns
            stack.push(current);
        }

        // result array
        int[] result = new int[m];

        for (int i = 0; i < m; i++)
            result[i] = map.get(subset[i]);

        // Return the final result
        return result;
    }

    // Approach-3(if the given array is circular) -> Using stack
    public static int[] nextGreaterElementCircular(int nums[]) {

        // Find lengths
        int n = nums.length;

        // Stack to keep track of the next greater element
        Stack<Integer> stack = new Stack<>();

        // Result nge array for the storage of next greater element
        int[] result = new int[n];

        // Start from virtually doubling the array and traversing it
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Get the current element
            int current = nums[i % n];

            // Remove elements of stack until the stack is empty or current element > top
            while (!stack.isEmpty() && current >= stack.peek())
                stack.pop();

            // If the current index is in range, update nge for current
            if (i < n)
                result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Add the current element in stack for next elements
            stack.push(current);
        }

        // Return the final result array
        return result;
    }
}
