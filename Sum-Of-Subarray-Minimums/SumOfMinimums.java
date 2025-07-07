import java.util.Stack;

public class SumOfMinimums {

    // Approach-1 -> Using the contribution technique by nse and pse
    public static int sumOfMinimums(int[] nums) {

        // Find length
        int n = nums.length;

        // Find mod
        int mod = (int) (1e9 + 7);

        // Find nse
        int[] nse = findNSE(nums), psee = findPSEE(nums);

        // Traverse the nums
        int sum = 0;

        for (int i = 0; i < n; i++) {

            // Find the left contribution
            int leftContribution = psee[i] - i;

            // Find the right contribution
            int rightContribution = nse[i] - i;

            sum = (sum + (leftContribution * rightContribution * nums[i]) % mod) % mod;
        }

        // return sum
        return sum % mod;
    }

    private static int[] findPSEE(int[] nums) {

        // Find length
        int n = nums.length;

        // Stack to keep track of the previous smaller or equal elements
        Stack<Integer> stack = new Stack<>();

        // Result psee array for the mapping
        int[] psee = new int[n];

        // Traverse the nums array
        for (int i = 0; i < n; i++) {

            // Find the current element
            int current = nums[i];

            // Remove from stack until its empty or element < top
            while (!stack.isEmpty() && current < nums[stack.peek()])
                stack.pop();

            // Add pse for the current element
            psee[i] = stack.isEmpty() ? -1 : stack.peek();

            // Add the current index for next elements
            stack.push(i);
        }

        // Return psee for the further elements
        return psee;
    }

    private static int[] findNSE(int[] nums) {

        // Find length
        int n = nums.length;

        // Stack to keep track of the next smaller
        Stack<Integer> stack = new Stack<>();

        // Result nse array for the mapping
        int[] nse = new int[n];

        // Traverse nums
        for (int i = n - 1; i >= 0; i--) {

            // Find current element
            int current = nums[i];

            // Remove from stack until empty or current < top
            while (!stack.isEmpty() && current <= nums[stack.peek()])
                stack.pop();

            // Map the current nse
            nse[i] = stack.isEmpty() ? n : stack.peek();

            // Add the current index for further elements
            stack.push(i);
        }

        // Return nse
        return nse;
    }
}
