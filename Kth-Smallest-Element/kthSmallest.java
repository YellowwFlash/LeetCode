import java.util.Arrays;
import java.util.PriorityQueue;

public class kthSmallest {

    // Approach-1 -> Using internal sorting
    public static int kthSmallestSorting(int[] nums, int k) {

        // Sort the current array
        Arrays.sort(nums);

        // Return the k-1 the index to find the kth smallest element
        return nums[k - 1];
    }

    // Approach-2 -> Using max heap of fixed size
    public static int kthSmallestMaxHeap(int[] nums, int k) {
        // Create a max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        // For single traversal, keep fixed size of k else remove the unwanted
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }

        // Return the kth smallest element
        return heap.peek();
    }
}
