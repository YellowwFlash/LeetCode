import java.util.Arrays;

public class ShortestJobFirst {

    // Approach-1 -> Using the sfu algorithm
    public static int shortestJobFirst(int[] times) {

        // Find the length of times
        int n = times.length;

        // Sort the times to do the shortest job first
        Arrays.sort(times);

        // Define total time, and wait time 
        int totalTime = 0, waitTime = 0;

        // Iterate throgugh the times
        for (int time : times) {

            // Update the wait time
            waitTime += totalTime;

            // Update the total time
            totalTime += time;
        }
        
        // Return the average waiting time
        return (waitTime / n);
    }
}
