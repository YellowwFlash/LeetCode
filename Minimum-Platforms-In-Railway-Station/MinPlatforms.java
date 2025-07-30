import java.util.Arrays;

public class MinPlatforms {

    // Apprach-1 -> Using individual greedy sorting method
    public static int findMinPlatforms(int[] arrival, int[] departure) {

        // Find length of array
        int n = arrival.length;

        // Define two pointers for arrival and departure
        int i = 0, j = 0;

        // Define count of platforms and maximum count
        int count = 0, maxCount = 0;

        // Sort the arrival and departure arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        // Traverse the arrays
        while (i < n && j < n) {

            // IF the arrival time is less than or equal to departure time,
            // another platform will be required. Hence increase count
            if (arrival[i] <= departure[j]) {

                // Increase count
                count++;

                // Increment i
                i++;
            }

            // If not, then simply decrement count because no new platform required
            else {

                // Decrease count
                count--;

                // Increment j
                j++;
            }

            // Update maxCount
            maxCount = Math.max(maxCount, count);
        }

        // Return maxCount as the final count of minimum platforms
        return maxCount;
    }
}
