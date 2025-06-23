public class StringAtoi {

    // Approach-1 -> Using normal logic
    public static int myAtoi(String s) {

        int n = s.length(), sign = 1, number = 0, index = 0;

        // Remove all the leading whitespaces
        while (index < n && Character.isWhitespace(s.charAt(index)))
            index++;

        // Check for the signs
        if (index < n) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // Convert all the charaters to digits
        while (index < n && Character.isDigit(s.charAt(index))) {

            // Convert current char to digit
            int digit = s.charAt(index) - '0';

            // Check for integer overflow
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Add the digit to number
            number = number * 10 + digit;
            index++;
        }

        // Return the number after multiplying the sign
        return sign * number;
    }
}
