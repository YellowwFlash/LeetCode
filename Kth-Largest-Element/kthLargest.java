import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargest {

    // Approach-1 -> Using internal sorting
    public static int findKthLargestSorting(int[] nums, int k) {

        // Sort the numbers first
        Arrays.sort(nums);

        // Return the kth largest element as it'll be n-kth element
        return nums[nums.length - k];

    }

    // Approach-2 -> Using priority queue
    public static int findKthLargestPriorityQueue(int[] nums, int k) {
        // Create a priority queue for max heap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        // Offer elements to queue
        for (int num : nums)
            queue.offer(num);

        // Loop till k times and remove respective elements
        for (int i = k; i > 1; i--)
            queue.poll();

        return queue.poll();
    }

    // Approach-3 -> Using min heap to store only k elements
    public static int findKthLargestMinHeap(int[] nums, int k) {
        // Create a min heap of size k
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Add only k elements. If the size exceeds k elements, remove the smallest one
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k)
                queue.poll();
        }

        // Return the top element because it'll be the kth largest one
        return queue.peek();
    }

}