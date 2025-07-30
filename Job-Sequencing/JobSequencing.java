import java.util.Arrays;

public class JobSequencing {

    static class Job {
        int id, profit, deadline;

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }

    }

    // Approach-1 -> Using Greedy sorting method
    public static int[] jobSequencing(int[] profit, int[] deadline, int ids[]) {

        // Find the length of the array
        int n = profit.length;

        // Find the maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++)
            maxDeadline = Math.max(maxDeadline, deadline[i]);

        // Create a Job array for sorting purposes
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Job(ids[i], profit[i], deadline[i]);

        // Sort the jobs based on their profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Define a result array to store the selected jobs
        int[] result = new int[maxDeadline];

        // Fill the array with -1 since no job has been selected yet
        Arrays.fill(result, -1);

        // Iterate through the sorted jobs
        for (Job job : jobs) {

            // Get the deadline of the current job
            int d = job.deadline, id = job.id;

            // Start from the last day and move backwards to find an empty slot
            for (int i = d; i > 0; i--) {
                // If the slot is empty, assign the job to that slot
                if (result[i - 1] == -1) {
                    result[i - 1] = id;

                    // Break the loop since we have found a suitable slot
                    break;
                }
            }
        }

        // Return result as the final result
        return result;
    }
}
