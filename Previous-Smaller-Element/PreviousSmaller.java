import java.util.Arrays;
import java.util.Stack;

public class PreviousSmaller {

    // Approach-1 -> Using loops
    public static int[] previousSmallerLoops(int[] nums) {

        // Find length
        int n = nums.length;

        // Result pse array for each element
        int[] pse = new int[n];

        // Fill the array with -1
        Arrays.fill(pse, -1);

        // Traverse nums from backwards and for each one, find smaller
        for (int i = n - 1; i >= 0; i--) {

            // Find smaller for current element
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] < nums[i]) {
                    pse[i] = nums[j];
                    break;
                }
        }

        // Return the pse array as previous smaller for each element
        return pse;
    }

    // Approach-2 -> Using stack
    public static int[] previousSmallerStack(int[] nums) {

        // Find length
        int n = nums.length;

        // Stack to store the previous smaller elements
        Stack<Integer> stack = new Stack<>();

        // Result pse array for each element
        int[] pse = new int[n];

        // Traverse nums
        for (int i = 0; i < n; i++) {

            // Find current
            int current = nums[i];

            // Remove from stack until stack is empty or current is <= top
            while (!stack.isEmpty() && current <= stack.peek())
                stack.pop();

            // Add pse for current element
            pse[i] = stack.isEmpty() ? -1 : stack.peek();

            // Add current element for the next elements
            stack.push(current);
        }

        // Return pse as the final Result
        return pse;
    }
}
