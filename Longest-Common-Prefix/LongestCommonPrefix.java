public class LongestCommonPrefix {

    // Approach-1 -> Using the minimum string method
    public static String longestCommonPrefix(String[] strings) {

        // Find the shortest string and its index
        int minIndex = 0, minLength = strings[0].length();

        for (int i = 0; i < strings.length; i++) {

            String string = strings[i];

            // Check if the length of current string is smaller than minLength
            if (string.length() < minLength) {
                // Update the min length to current string length
                minLength = string.length();
                // Update the min index to be current index
                minIndex = i;
            }
        }

        String smallest = strings[minIndex];
        StringBuilder prefix = new StringBuilder();

        // Start traversal on all strings array
        for (int i = 0; i < strings.length; i++) {

            // If the string at current index is equal to the string at minIndex, continue
            if (i == minIndex)
                continue;

            // Check if smallest string is empty to return early for optimization
            if (smallest.isEmpty())
                break;

            // Check until when both the strings have equal characters
            for (int j = 0; j < smallest.length(); j++) {

                // Check if character at current string and smallest string are equal
                if (strings[i].charAt(j) == smallest.charAt(j))
                    // Append into prefix
                    prefix.append(strings[i].charAt(j));

                // If not then just break
                else {
                    break;
                }
            }

            // Update the smallest string since there cant be a bigger prefix if its smaller
            smallest = prefix.toString();
            // Reset the prefix string
            prefix.setLength(0);
        }

        return smallest;
    }
}
