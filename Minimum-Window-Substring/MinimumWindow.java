public class MinimumWindow {

    // Approach-1 -> Using the sliding window and preinsertion technique
    public String minWindow(String s, String t) {

        // If any of the strings are empty, return an empty string
        if (s.isEmpty() || t.isEmpty())
            return "";

        // Find the lengths of the strings
        int n = s.length(), m = t.length();

        // Define character frequency hashmap
        int[] hash = new int[128];

        // Preinsert the map with characters of t
        for (char ch : t.toCharArray())
            hash[ch]++;

        // Define pointers for the sliding window
        int left = 0, right = 0, count = 0, minLength = (int) (1e9), start = -1;

        // Iterate through the string s using the sliding window technique
        while (right < n) {

            // Get the current character
            char current = s.charAt(right);

            // If the character frequency is 0, means it was preinserted
            if (hash[current] > 0)
                count++;

            // Add the character to the hashmap by reducing its frequency
            hash[current]--;

            // Find the minimum window
            while (count == m) {

                // If the current length is less than minimum, update it
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Shrink the window from the left
                char leftChar = s.charAt(left);
                hash[leftChar]++;

                // If the frequency crosses 0, then its reinserted
                if (hash[leftChar] > 0)
                    count--;

                // Move the left pointer to shrink the window
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        // If no valid window was found, return an empty string
        // Return the minimum window substring
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
}
