public class Divide {

    // Approach-1 -> Using normal subtraction
    public static int divideSubtraction(int dividend, int divisor) {

        // if dividend or divisor is 0, return 0
        if (dividend == 0 || divisor == 0)
            return 0;

        int count = 0;

        while (dividend - divisor > divisor)
            count++;

        // Return the final count of the times divisor can be removed
        return count;
    }

    // Approach-2 -> Using bit manipulation
    public static int divideBitManipulation(int dividend, int divisor) {

        // Explicitly handle the special case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // If dividend and divisor are same, return 1
        if (dividend == divisor)
            return 1;

        // Check for the sign
        boolean sign = (dividend < 0) == (divisor < 0);

        // Find the absolute of both values to divide
        long x = Math.abs(dividend), div = Math.abs(divisor), quotient = 0;

        // Loop through until x >= div
        while (x >= div) {

            // Define a counter for the times div can be removed
            int count = 0;

            // Finding which power of two could be the highest to remove
            while (x >= (div << (count + 1)))
                count++;

            // Remove the count of 2's power from x
            x -= (div << count);

            // Add the power of 2 to the quotient
            quotient += (1 << count);
        }

        // Check overflow
        if (quotient > Integer.MAX_VALUE)
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        // Return the final inbound quotient according to sign
        return (int) (sign ? quotient : -quotient);
    }
}
