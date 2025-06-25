import java.util.HashSet;

public class Longest {

    // Approach-1 -> Using sliding window technique(only for lowercase)
    public static int longestSubstring(String s) {

        // Pointers for the traversal
        int left = 0, right = 0;
        int n = s.length();

        // Frequency map to keep track of the frequencies
        int[] frequency = new int[26];
        int maxLength = 0;

        // String traversal
        while (left <= right && right < n) {

            char rChar = s.charAt(right);

            // Add the character at right to the frequency map if there isnt one in string
            if (frequency[rChar - 'a'] == 0) {
                // Add the frequency
                frequency[rChar - 'a']++;

                // Increase the right pointer
                right++;
            }

            // If not, then increase the left pointer until the char at right has frequency
            // as 0
            else {
                while (frequency[rChar - 'a'] != 0)

                    // Decrease the frequency of left pointer char and increase the left pointer
                    frequency[s.charAt(left++) - 'a']--;

            }
            // Update the max length
            maxLength = Math.max(maxLength, right - left);
        }

        // Ṛeturn the max length
        return maxLength;
    }

    // Approach-2 -> Using sliding window and hashset
    public static int longestSubstringHashSet(String s) {

        // Pointers for traversal
        int left = 0, right = 0;
        int n = s.length(), maxLength = 0;

        // HashSet to keep track of the duplicates
        HashSet<Character> set = new HashSet<>();

        // String traversal
        while (left <= right && right < n) {

            // Current char
            char rChar = s.charAt(right);

            // If the current char is not seen, then only add it
            if (!set.contains(rChar)) {
                // Add the char to the set
                set.add(rChar);
                // Increase the right pointer
                right++;
            }
                
            // If not, then remove all the chars to unseen the current char
            else 
                // Remove the leftmost char from the set
                while(set.contains(rChar))
                    set.remove(s.charAt(left++));

            // Update the maxLength
            maxLength = Math.max(maxLength, right - left);
        }


        return maxLength;
    }
}