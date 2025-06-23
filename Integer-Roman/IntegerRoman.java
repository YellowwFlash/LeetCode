public class IntegerRoman {

        // Approach-1 -> Using the division and modulo
        public static String intToRoman(int num) {

            // Define the numbers and symbols
            int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
            String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

            // Result string
            StringBuilder result = new StringBuilder();

            // Loop through all the values and symbols
            for (int i = 0; i < values.length; i++) {

                int current = values[i];
                String symbol = symbols[i];

                // If the number >= current value, subtract value and add symbol to result
                while (num >= current) {
                    // Decrease the number by the current value
                    num -= current;
                    // Add the symbol to the result
                    result.append(symbol);
                }
            }

            return result.toString();
        }
}
