public class Power {

    // Approach-1 -> Using power exponentiation technique
    public static long power(long base, long exponent) {

        if (exponent < 0 || base == 0)
            return 0;

        if (exponent == 0)
            return 1;

        // Answer variable
        long answer = 1;

        // Traverse until the exponent > 0
        while (exponent > 0) {

            // If the current exponent is odd, make it even
            if ((exponent & 1) == 1) {

                // Multiply the base with answer once
                answer *= base;

                // Remove 1 from exponent
                exponent--;
            }

            // If not, simply divide the exponent by half and square the base
            else {

                // Square the base
                base *= base;

                // Divide the exponent by 2
                exponent >>= 1;
            }
        }

        // Return the final answer
        return answer;
    }
}
