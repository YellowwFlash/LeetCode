public class FancyString {

    // Approach-1 -> Using the pointer technique
    public static String fancyString(String s) {

        // Make stringbuilder for efficient appending
        StringBuilder result = new StringBuilder();

        // A count and current char to keep track
        int count = 0;
        char current = ' ';

        // Travese the string
        for (char ch : s.toCharArray()) {

            // If the current character is the same as the previous one, increment the count
            if (ch == current) {
                // Increase the count if the count is less than 3 and append the character
                if (count < 3) {
                    count++;
                    result.append(ch);
                }
            }

            // If the current character is different than ch, change the current and count
            else {
                current = ch;
                count = 1;
                result.append(ch);
            }
        }

        return result.toString();
    }
}
