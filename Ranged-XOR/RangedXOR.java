public class RangedXOR {

    // Approach-1 -> Using the traversal
    public static int findXORTraversal(int left, int right) {

        // Result xor
        int result = 0;

        // Traverse from left till right and find xor
        for (int i = left; i <= right; i++)
            result ^= i;

        // Return the result xor
        return result;
    }

    // Approach-2 -> Using a special xor pattern
    public static int findXORPattern(int left, int right) {

        // Return the xor of 1 to left-1 and 1 to right
        return (xor(left - 1) ^ xor(right));
    }

    // Method to find the xor of 1 to n
    private static int xor(int n) {

        // Universal xor pattern
        if (n % 4 == 1)
            return 1;

        else if (n % 4 == 2)
            return n + 1;

        else if (n % 4 == 3)
            return 0;

        else
            return n;
    }
}
