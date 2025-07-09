import java.util.Stack;

public class SumOfRanges {

    // Approach-1 -> Using sum of minimums and maximums in subarray
    public static int sumOfRanges(int[] nums) {

        int mod = (int) (1e9 + 7);

        // Find sum of subarray minimums
        int subarrayMin = findSubarrayMinimumSum(nums);

        // Find sum of subarray maximums
        int subarrayMax = findSubarraymaximumSum(nums);

        // Return the final sum by max - min
        return ((subarrayMax - subarrayMin) % mod + mod) % mod;
    }

    private static int findSubarraymaximumSum(int[] nums) {

        // Find length
        int n = nums.length, mod = (int) (1e9 + 7);

        // Find the next greater element for each element
        int[] nextGreater = findNGE(nums);

        // Find the previous greater or equal element for each element
        int[] prevGreater = findPGEE(nums);

        // Initialize the sum of subarray maximums
        int sum = 0;

        // Traverse the array to calculate the contribution of each element
        for (int i = 0; i < n; i++) {
            // Calculate the left contribution
            int leftContribution = i - prevGreater[i];

            // Calculate the right contribution
            int rightContribution = nextGreater[i] - i;

            // Update the sum with the contribution of the current element
            sum = (sum + (leftContribution * rightContribution * nums[i]) % mod) % mod;
        }

        return sum;
    }

    private static int[] findPGEE(int[] nums) {
        // Find length
        int n = nums.length;

        // Create an array to store the previous greater or equal elements
        int[] prevGreater = new int[n];

        // Create a stack to keep track of indices
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {

            // Pop elements from the stack until we find a greater or equal element
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no greater or equal element to the left
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the array of previous greater or equal elements
        return prevGreater;
    }

    private static int[] findNGE(int[] nums) {
        // Find length
        int n = nums.length;

        // Create an array to store the next greater elements
        int[] nextGreater = new int[n];

        // Create a stack to keep track of indices
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from the stack until we find a greater element
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no greater element to the right
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the array of next greater elements
        return nextGreater;
    }

    private static int findSubarrayMinimumSum(int[] nums) {

        // Find length
        int n = nums.length, mod = (int) (1e9 + 7);

        // Find the next smaller element for each element
        int[] nextSmaller = findNSE(nums);

        // Find the previous smaller or equal element for each element
        int[] prevSmaller = findPSEE(nums);

        // Initialize the sum of subarray minimums
        int sum = 0;

        // Traverse the array to calculate the contribution of each element
        for (int i = 0; i < n; i++) {
            // Calculate the left contribution
            int leftContribution = i - prevSmaller[i];

            // Calculate the right contribution
            int rightContribution = nextSmaller[i] - i;

            // Update the sum with the contribution of the current element
            sum = (sum + (leftContribution * rightContribution * nums[i]) % mod) % mod;
        }

        return sum;
    }

    private static int[] findPSEE(int[] nums) {
        // Find length
        int n = nums.length;

        // Create an array to store the previous smaller or equal elements
        int[] prevSmaller = new int[n];

        // Create a stack to keep track of indices
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {

            // Pop elements from the stack until we find a smaller or equal element
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no smaller or equal element to the left
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the array of previous smaller or equal elements
        return prevSmaller;
    }

    private static int[] findNSE(int[] nums) {
        // Find length
        int n = nums.length;

        // Create an array to store the next smaller elements
        int[] nextSmaller = new int[n];

        // Create a stack to keep track of indices
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from the stack until we find a smaller element
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no smaller element to the right
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the array of next smaller elements
        return nextSmaller;
    }
}
