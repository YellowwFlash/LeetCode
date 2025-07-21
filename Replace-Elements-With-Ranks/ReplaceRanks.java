import java.util.PriorityQueue;

public class ReplaceRanks {

    // Approach-1 -> Using Priority Queue
    public int[] replaceElements(int[] nums) {

        // Find the length
        int n = nums.length;

        // Define a priority queue to store elements and their indices
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Fill the priority queue with elements and their indices
        for (int i = 0; i < n; i++)
            queue.offer(new int[] { nums[i], i });

        // Define rank to be placed for elements
        int rank = 0;

        // Iterate the queue until it is empty
        while (!queue.isEmpty()) {

            // Get the current smallest element
            int[] current = queue.poll();

            // Get the value and index of the current element
            int value = current[0], index = current[1];

            // Set the rank of the current element
            nums[index] = rank;

            // If the next element is the same, do not increment rank
            if (!queue.isEmpty() && queue.peek()[0] == value)
                continue;

            // Increment the rank for the next unique element
            rank++;
        }

        // Return the modified array with ranks
        return nums;
    }
}
