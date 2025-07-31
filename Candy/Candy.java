public class Candy {

    // Approach-1 -> Using left and right arrays
    public static int maxCandiesLeftRight(int[] candidates) {

        // Find the length of the candidates array
        int n = candidates.length;

        // Define left and right array for storing the maximum candies
        int[] left = new int[n], right = new int[n];

        // Predefine the values of left and right arrays
        left[0] = right[n - 1] = 1;

        // Fill up the left array
        for (int i = 1; i < n; i++) {

            // If the current element > the previous element, increase value by 1
            if (candidates[i] > candidates[i - 1])
                left[i] = left[i - 1] + 1;

            // Otherwise, set the value to 1
            else
                left[i] = 1;
        }

        // Fill up the right array
        for (int i = n - 2; i >= 0; i--) {

            // If the current element > the next element, increase value by 1
            if (candidates[i] > candidates[i + 1])
                right[i] = right[i + 1] + 1;

            // Otherwise, set the value to 1
            else
                right[i] = 1;
        }

        // Traverse both arrays and find max of both and sum it up
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.max(left[i], right[i]);

        // Return sum as the final answer of candies
        return sum;
    }

    // Approach-2 -> Using left array only
    public static int maxCandiesLeft(int[] candidates) {

        // Find length of candidates array
        int n = candidates.length;

        // Define left array to keep track of maximum candies
        int[] left = new int[n];

        // Predefine the value of left array
        left[0] = 1;

        // Traverse the array and find the max candies
        for (int i = 1; i < n; i++)
            left[i] = candidates[i] > candidates[i - 1] ? left[i - 1] + 1 : 1;

        // Start from the end and find the max candies
        int right = 1, current = 1, maxSum = left[n - 1];
        for (int i = n - 2; i >= 0; i--) {

            // If the current element > the next element, increase value by 1
            if (candidates[i] > candidates[i + 1]) {
                current = right + 1;
                right = current;
            }
            // If not, set the value to 1
            else
                current = 1;

            // Update the max sum
            maxSum += Math.max(left[i], current);
        }

        // Return max sum as the final answer of candies
        return maxSum;
    }

    // Approach-3 -> Using the peak approach
    public static int maxCandiesPeak(int[] candidates) {

        // Find the length of candidates array
        int n = candidates.length;

        // Define index for traversal
        int index = 1;

        // Define the maximum candies
        int maxCandies = 1;

        // Traverse the array and find the max candies
        while (index < n) {

            // If a flat slop, assign value 1 and continue
            if (candidates[index] == candidates[index - 1]) {

                // Update the max candies
                maxCandies += 1;
                index++;
                continue;
            }

            // If a peak, increase the value
            int peak = 1;
            while (index < n && candidates[index] > candidates[index - 1]) {

                // Increase the peak value
                peak++;

                // Update the max candies
                maxCandies += peak;

                index++;
            }

            // If its a steep, start from 1
            int down = 1;
            while (index < n && candidates[index] < candidates[index - 1]) {

                // Add down to the max candies
                maxCandies += down;

                // Increase the down value
                down++;

                index++;
            }

            // If the down is greater than the peak, assign the difference and add it
            if (down > peak)
                maxCandies += down - peak;
        }

        // Return max candies as the final answer of candies
        return maxCandies;
    }
}