public class FindTransitions {

    // Approach-1 -> Using XOR operator and counting bits
    public static int findTransitions(int start, int goal) {

        // Find the xor of start and goal numbers
        int xor = start ^ goal;

        // Find the total set bits of xor and return it
        return countSetBits(xor);
    }

    private static int countSetBits(int n) {

        // Loop through until n is non zero
        int setBits = 0;

        while (n != 0) {

            // If the rightmost bit is set, increase setBits
            if ((n & 1) == 1)
                setBits += 1;

            // Right shift n by 1
            n = n >> 1;
        }

        // Return the final setBits
        return setBits;
    }
}
