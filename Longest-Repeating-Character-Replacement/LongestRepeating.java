public class LongestRepeating {

    // Approach-1 -> Using counting and sliding window
    public static int longestCharacterReplacement(String s, int k) {

        int n = s.length();

        // If length is 0, return 0
        if (n == 0)
            return 0;

        // Window pointers
        int left = 0, right = 0;

        // Frequency count for the chars
        int[] freq = new int[26];
        int maxFreq = 0, maxLength = 0;

        while (right < n) {

            char current = s.charAt(right);
            // Add the frequency
            freq[current - 'A']++;

            // Find the highest frequency
            maxFreq = Math.max(maxFreq, freq[current - 'A']);

            // If the max frequency and least changable are greater than k, not valid
            if (right - left + 1 - maxFreq > k)
                // Shrink the window size and reduce the frequency
                freq[s.charAt(left++) - 'A']--;

            // Update the max length
            maxLength = Math.max(maxLength, right - left + 1);

            // Update the right pointer
            right++;
        }

        // Return the max length
        return maxLength;
    }
}
