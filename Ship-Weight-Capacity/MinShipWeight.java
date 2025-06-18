public class MinShipWeight {

    // Approach-1 -> Using the linear scan
    public static int minShipWeightLoop(int[] weights, int days) {

        // Define the search space
        int start = findMax(weights);
        int end = findSum(weights);

        for (int i = start; i <= end; i++)
            if (isValidWeight(weights, days, i))
                return i;

        return -1;
    }

    // Approach-2 -> Using binary search
    public static int minShipWeightBS(int[] weights, int days) {

        // Define the search space
        int low = findMax(weights), high = findSum(weights);
        int result = -1;

        // Binary search
        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check validity for mid
            if (isValidWeight(weights, days, mid)) {
                // Add mid as potential answer
                result = mid;
                // Search in left half for smaller value
                high = mid - 1;
            }

            // If not, go to the right half
            else
                low = mid - 1;
        }

        return result;
    }

    private static boolean isValidWeight(int[] weights, int days, int current) {

        int currentDays = 1, sum = 0;

        for (int weight : weights) {

            if (sum + weight > current) {
                currentDays++; // start a new day
                sum = weight; // load current weight on new day
            } else {
                sum += weight; // continue loading
            }
        }

        return currentDays <= days;
    }

    private static int findMax(int[] weights) {
        int max = weights[0];

        for (int weight : weights)
            max = Math.max(max, weight);

        return max;
    }

    private static int findSum(int[] weights) {
        int sum = 0;

        for (int weight : weights)
            sum += weight;

        return sum;
    }
}