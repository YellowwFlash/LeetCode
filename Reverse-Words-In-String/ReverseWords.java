public class ReverseWords {

    // Approach-1 -> Using the two pointers method
    public static String reverseWords(String s) {

        // Remove the leading and trailing spaces
        s = s.trim();

        // Split the string based on whitespaces
        String[] words = s.split("\\s+");

        // Defining the pointers
        int n = words.length;
        int start = 0, end = n - 1;

        while (start < end) {

            // Simply swap the strings
            String temp = words[start];
            words[start++] = words[end];
            words[end--] = temp;
        }

        // Return the newly formed string after jonining it with whitespace
        return String.join(" ", words);
    }

    // Approach-2 -> Using pointer technique
    public static String reverseWordsPointers(String s) {

        int n = s.length();

        // Result string
        StringBuilder result = new StringBuilder();

        // Pointer definition
        int end = n - 1;

        // Loop from the end
        while (end >= 0) {

            // First skip all the trailing spaces
            while (end >= 0 && Character.isWhitespace(s.charAt(end)))
                end--; // Move end pointer to the left

            // Break if end < 0
            if (end < 0)
                break;

            // Use start pointer to loop through valid chars
            int start = end;
            while (start >= 0 && !Character.isWhitespace(s.charAt(start)))
                start--; // Move start pointer to the left

            // Add whitespace if the result length is > 0
            if (result.length() > 0)
                result.append(' ');

            // Loop from start to end to insert the current word
            for (int i = start + 1; i <= end; i++)
                result.append(s.charAt(i)); // Append the word to the result string

            // Move the end pointer to start-1
            end = start - 1;
        }

        // Finally return the result string
        return result.toString();
    }
}
