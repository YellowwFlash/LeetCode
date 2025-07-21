import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    // Approach-1 -> Using Priority Queue
    public static int taskScheduler(char[] tasks, int n) {

        // Count the frequency of each task
        int[] freq = new int[26];

        for (char task : tasks)
            freq[task - 'A']++;

        // Create a max heap based on the frequency of tasks
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all the non zero frequency to head
        for (int f : freq)
            if (f > 0)
                maxHeap.offer(f);

        // Define a time and a wait queueu
        Queue<int[]> waitQueue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {

            // Increase the time
            time++;

            if (!maxHeap.isEmpty()) {
                // Get the top of the max heap which has max frequency
                int current = maxHeap.poll();

                // Add the current and time in queue
                if (current - 1 > 0)
                    waitQueue.offer(new int[] { current - 1, time + n });
            }

            // Check if the front of the queue has the cooldown reached
            if (!waitQueue.isEmpty() && waitQueue.peek()[1] <= time)
                // Add the task to the maxHeap
                maxHeap.add(waitQueue.poll()[0]);
        }

        // Return the total time taken as the final answer
        return time;
    }
}
