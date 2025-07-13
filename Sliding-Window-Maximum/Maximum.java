import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum {

    // Approach-1 -> Using Deque
    public static int[] slidingWindowMaximum(int[] nums, int k) {

        // Find length of nums and index
        int n = nums.length, index = 0;

        // Define result maximum array
        int[] result = new int[n - k + 1];

        // Define a deque to store indices of useful elements
        Deque<Integer> deque = new ArrayDeque<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {

            // Remove the elements that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();

            // Remove elements from the back of the deque that <= current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            // If we have filled the first window, add the maximum to the result
            if (i >= k - 1)
                result[index++] = nums[deque.peekFirst()];

            // Add the current element's index to the deque
            deque.offerLast(i);
        }

        // Return the result array
        return result;
    }
}
