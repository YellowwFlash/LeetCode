public class KokoEatingBananas {

    // Approach-1 -> Using linear traversal
    public static int minEatingSpeedLoop(int[] piles, int H) {

        // Find the maximum of the array
        int max = findMax(piles);

        // Loop from 1 till max to find min bananas
        for (int i = 1; i <= max; i++)

            // If the current hour is valid, since itll be smallest, return it
            if (isValid(piles, H, i))
                return i;

        return -1;
    }

    // Approach-2 -> Using binary search
    public static int minEatingSpeedBinarySearch(int[] piles, int H) {
        int low = 1, high = findMax(piles);

        // Search in the current search space
        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if mid is the possible value
            if (isValid(piles, H, mid))
                // Since mid is possible, check if smaller value is possible
                high = mid - 1;

            // If not then go to the right
            else
                low = mid + 1;
        }

        return low;
    }

    private static boolean isValid(int[] piles, int H, int hour) {

        int hours = 0;

        // Check for each pile if the current hour is valid
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / hour);
            // Overflow check
            if (hours > H)
                return false;

        }

        return true;
    }

    private static int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int pile : piles)
            max = Math.max(max, pile);

        return max;
    }
}
