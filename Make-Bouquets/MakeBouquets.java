public class MakeBouquets {

    // Approach-1 -> Using the linear scan
    public static int makeBouquetsLoops(int[] flowers, int k, int m) {

        // Find the min and max element for searching the correct day
        int answer[] = findMinMax(flowers);
        int min = answer[0], max = answer[1];

        // Search for the day in min to max space
        for (int i = min; i <= max; i++)

            // If the current day is valid, return it since it'll be the min one
            if (isValidDay(flowers, k, m, i))
                return i;

        return -1;
    }

    // Approach-2 -> Using Binary Search
    public static int makeBouquetsBinarySearch(int[] flowers, int k, int m) {

        int minmax[] = findMinMax(flowers);
        int low = minmax[0], high = minmax[1];

        int answer = -1;

        // Binary search
        while (low <= high) {

            // Find mid
            int mid = low + (high - low) / 2;

            // Check for mid as valid day
            if (isValidDay(flowers, k, m, mid)) {
                // Store mid as current answer and go to left to find min
                answer = mid;
                high = mid - 1;
            }

            // If not, go to the right
            else
                low = mid + 1;
        }

        return answer;
    }

    private static boolean isValidDay(int[] flowers, int k, int requiredBouquets, int currentDay) {

        // Count for the days
        int count = 0, bouquets = 0;

        for (int flower : flowers)

            // if the current day is going to be bigger, the flower will bloom
            if (flower <= currentDay)
                // Make the increament for consecutive blooms
                count++;
            else {
                // Check for how many bouquets could be made
                bouquets += count / k;
                // Reset the count to 0
                count = 0;

                // Check for overflow(optimization)
                if (bouquets == requiredBouquets)
                    return true;
            }

        // Add the count for remaining numbers
        bouquets += count / k;

        return bouquets >= requiredBouquets;
    }

    private static int[] findMinMax(int[] flowers) {
        int min = flowers[0], max = flowers[0];

        // Find the min and max
        for (int flower : flowers) {
            min = Math.min(min, flower);
            max = Math.max(max, flower);
        }

        return new int[] { min, max };
    }
}
