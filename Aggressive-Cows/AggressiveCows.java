import java.util.Arrays;

public class AggressiveCows {

    // Approach-1 -> Using linear search
    public static int findMaxMinDistanceLoop(int[] positions, int cows) {

        // First sort the array to find consecutive positions
        Arrays.sort(positions);

        // Define the search space
        int start = 1;
        int minmax[] = findMinMax(positions);
        int end = minmax[1] - minmax[0]; // The highest possible position will always be this
        int answer = 0;

        // Linear scan
        for (int i = start; i <= end; i++) {

            // Check if the current position is possible
            if (isPossibleDistance(positions, cows, i))
                answer = i;
            // If any position is not possible, all the values ahead of it wont be possible
            // since sorted array
            else
                break;
        }

        return answer;
    }

    // Approach-2 -> Using binary search
    public static int findMaxMinDistanceBinarySearch(int[] positions, int cows) {

        // First sort the array to find consecutive positions
        Arrays.sort(positions);

        // Define the search space
        int low = 1;
        int minmax[] = findMinMax(positions);
        int high = minmax[1] - minmax[0]; // The highest possible position
        int answer = 0;

        // Modified binary search
        while (low <= high) {

            // Find the mid
            int mid = low + (high - low) / 2;

            // Check if mid is the valid value
            if (isPossibleDistance(positions, cows, mid)) {
                // Add mid as the possible answer
                answer = mid;
                // Go to the right half to find the maximum possible distance
                low = mid + 1;
            }

            // If the mid is not possible, then go to left to find minimum
            else
                high = mid - 1;
        }

        return answer;
    }

    private static boolean isPossibleDistance(int[] positions, int cows, int limit) {
        int prevDistance = -1;

        for (int position : positions) {

            // If there is no previous position or current position is valid, place the cow
            if (prevDistance == -1 || position - prevDistance >= limit) {
                prevDistance = position;
                cows--;
            }

            // If all the cows are placed, the position is valid
            if (cows <= 0)
                return true;
        }

        return !(cows > 0);
    }

    private static int[] findMinMax(int[] positions) {
        int min = positions[0], max = positions[0];

        for (int position : positions) {
            min = Math.min(position, min);
            max = Math.max(position, max);
        }

        return new int[] { min, max };
    }
}
