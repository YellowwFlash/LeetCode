public class NthRoot {

    // Approach-1 -> Using in built function
    public static int nthRoot(int number, int n) {
        int answer = (int) (Math.pow(number, 1.0 / n));
        return answer == 0 ? -1 : answer;
    }

    // Approach-2 -> Using linear scan
    public static int nthRootLoop(int number, int n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return number;

        if (number == 0 || number == 1)
            return number;

        // Start the scan from 1 to number/2
        for (int i = 1; i <= number / 2; i++)
            // Check if the i power n is equal to number
            if ((long) Math.pow(i, n) == number)
                return i;

        return -1;
    }

    // Approach-3 -> Using modified binary search
    public static int nthRootBS(int number, int n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return number;

        if (number == 0 || number == 1)
            return number;

        int low = 1, high = number / 2;
        // To optimize the search bounds
        // high = (int)(Math.min(number, Math.pow(number, 1.0/n))) + 1;

        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;
            long power = power(mid, n, number);

            // Check if mid is the root
            if (power == number)
                return mid;

            // Check for right side
            else if (power < number)
                low = mid + 1;

            // If nothing, go to left
            else
                high = mid - 1;
        }

        return -1;
    }

    private static long power(int base, int exponent, int limit) {
        long result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
            // Check for overflow
            if (result > limit)
                return -1;
        }

        return result;
    }
}