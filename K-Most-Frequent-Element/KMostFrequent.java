import java.util.HashMap;
import java.util.PriorityQueue;

public class KMostFrequent {

    // Approach-1 -> Using hashing and priority queue
    public static int[] topKFrequent(int[] nums, int k) {

        // Define a hashmap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each element
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // Define a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Add the elements to the priority queue
        for (int key : map.keySet()) {

            // Add the element to the priority queue
            pq.add(new int[] { key, map.get(key) });

            // If the size of the priority queue is greater than k, remove the least
            // frequent element
            if (pq.size() > k)
                pq.poll();
        }

        // Define an array to store the top k frequent elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++)
            result[i] = pq.poll()[0];

        // Return result as the final answer
        return result;
    }
}
