import java.util.PriorityQueue;

public class ConnectRopes {

    // Approach-1 -> Using priority queue
    public int minCost(int[] ropes) {

        // Define a priority queue
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Firstly, add all the elements in queue
        for (int rope : ropes)
            queue.offer(rope);

        // Traverse until the queue size is empty
        int cost = 0;

        while (queue.size() > 1) {

            // Find the top element
            int first = queue.poll();
            int second = queue.poll();

            // Add the top elements
            cost += first + second;

            // Add the sum of the top elements
            queue.offer(first + second);
        }

        // Return the cost as the final answer
        return cost;
    }
}