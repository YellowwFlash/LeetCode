import java.util.PriorityQueue;

public class SortKSorted {

    // Approach-1 -> Using Priority Queue
    public static int[] sortKSorted(int[][] nums) {

        // Define the lengths of the input arrays
        int k = nums.length, n = 0;

        // Find the length of all the arrays
        for (int[] array : nums)
            n += array.length;

        // Define result array for the sorted output
        int[] result = new int[n];

        // Create a priority queue to hold the elements of the k sorted arrays
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Define index to track the position in the result array
        int index = 0;

        // Add the first element of each array to the priority queue
        for (int i = 0; i < k; i++) {
            if (nums[i].length > 0) {
                queue.offer(new int[] { nums[i][0], i, 0 }); // {value, array index, element index}
            }
        }

        // Iterate through the priority queue until it's empty
        while (!queue.isEmpty()) {

            // Get the smallest element from the queue
            int[] current = queue.poll();

            // Get the details from current element
            int value = current[0], arrayIndex = current[1], elementIndex = current[2];

            // Add the current value to result array
            result[index++] = value;

            // If the next of the current element exists, add it to the queue
            if (elementIndex + 1 < nums[arrayIndex].length)
                queue.offer(new int[] { nums[arrayIndex][elementIndex + 1], arrayIndex, elementIndex + 1 });
        }

        // Return the sorted result array
        return result;
    }
}
