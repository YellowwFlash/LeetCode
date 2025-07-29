public class ValidString {

    // Approach-1 -> Using the valid parentheses technique
    public static boolean isValid(String s) {

        // Define min and max to keep track of range of parentheses
        int min = 0, max = 0;

        for (char ch : s.toCharArray()) {

            // If opening parentheses, increase min and max
            if (ch == '(') {
                min++;
                max++;
            }

            // If closing parentheses, decrease min and max
            else if (ch == ')') {
                min--;
                max--;
            }

            // If *, then make the range by decreasing min and increasing max
            else {
                min--;
                max++;
            }

            // If min goes below 0, make it 0
            if (min < 0)
                min = 0;

            // If max goes below 0, return false since its invalid
            if (max < 0)
                return false;
        }

        // Return true if min is 0, else return false
        return min == 0;
    }
}
