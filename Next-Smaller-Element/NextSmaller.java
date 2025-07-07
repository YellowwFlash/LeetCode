import java.util.Stack;

public class NextSmaller {

    // Approach-1 -> Using the loop traversal
    public static int[] nextSmallerLoops(int[] nums) {

        // Find length
        int n = nums.length;

        // Result nse array to for each of the elements
        int[] nse = new int[n];

        // Fill the array with -1

        // Traverse the nums
        for (int i = 0; i < n; i++) {

            // Find the smaller element for current element
            for (int j = i + 1; j < n; j++)
                if (nums[j] < nums[i])
                    nse[i] = nums[j];
        }

        // Return the final result nse array
        return nse;
    }

    // Approach-2 -> Using stack
    public static int[] nextSmallerStack(int[] nums) {

        // Find length
        int n = nums.length;

        // Stack to keep track of the smalller elements
        Stack<Integer> stack = new Stack<>();

        // Result nse array for each of the element
        int[] nse = new int[n];

        // Traverse the array from backwards
        for (int i = n - 1; i >= 0; i--) {

            // Find current element
            int current = nums[i];

            // Remove the elements from stack until current < top of stack
            while (!stack.isEmpty() && current <= stack.peek())
                stack.pop();

            // Add the next smaller element for current
            nse[i] = stack.isEmpty() ? -1 : stack.peek();

            // Add the current element for the next elements
            stack.push(current);
        }

        // Return final nse array
        return nse;
    }
}
