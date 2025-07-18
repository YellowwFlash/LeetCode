import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    // Approach-1 -> Using sliding window technique
    public static int lengthOfLongestSubstringKDistinctSliding(String s, int k) {

        // Find length of the string
        int n = s.length();

        // Define pointers for the sliding window
        int left = 0, right = 0;

        // Define map to store the frequency of characters in the current window
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Variable to store the maximum length of substring found
        int maxLength = 0;

        // Iterate through the string with the right pointer
        while (right < n) {

            // Get the current character and update its count in the map
            char currentChar = s.charAt(right);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

            // Check if the current window is valid or not and validate it
            while (charCountMap.size() > k) {

                // If the window is invalid, move the left pointer to reduce the size
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);

                // If the count of the left character becomes zero, remove it from the map
                if (charCountMap.get(leftChar) == 0)
                    charCountMap.remove(leftChar);

                // Move the left pointer to the right
                left++;
            }

            // Update the maximum length of substring found
            maxLength = Math.max(maxLength, right - left + 1);

            // Move the right pointer to expand the window
            right++;
        }

        // Return the maximum length of substring found
        return maxLength;
    }

    // Approach-2 -> Using optimized sliding window technique
    public static int lengthOfLongestSubstringKDistinctOptimized(String s, int k) {
        // Find length of the string
        int n = s.length();

        // Define pointers for the sliding window
        int left = 0, right = 0;

        // Define map to store the frequency of characters in the current window
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Variable to store the maximum length of substring found
        int maxLength = 0;

        // Iterate through the string with the right pointer
        while (right < n) {

            // Get the current character and update its count in the map
            char currentChar = s.charAt(right);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

            // Check if the current window is valid or not and validate it
            if (charCountMap.size() > k) {

                // If the window is invalid, move the left pointer to reduce the size
                char leftChar = s.charAt(left);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);

                // If the count of the left character becomes zero, remove it from the map
                if (charCountMap.get(leftChar) == 0)
                    charCountMap.remove(leftChar);

                // Move the left pointer to the right
                left++;
            }

            // Update the maximum length of substring found
            maxLength = Math.max(maxLength, right - left + 1);

            // Move the right pointer to expand the window
            right++;
        }

        // Return the maximum length of substring found
        return maxLength;
    }
}