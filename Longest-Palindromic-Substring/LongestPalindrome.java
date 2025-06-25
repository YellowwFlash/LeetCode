public class LongestPalindrome {

    // Approach-1 -> Using central expansion
    public static String longest(String s) {

        // Pointers that keep the index of susbtring
        int start = 0, end = 0;
        int n = s.length();

        // Traversal in whole string
        for (int i = 0; i < n; i++) {

            // Odd length center expansion
            int len1 = expandAroundCenter(s, i, i, n);

            // Even length center expansion
            int len2 = expandAroundCenter(s, i, i + 1, n);

            // Maximum length
            int len = Math.max(len1, len2);

            // If the length is greater than start-end, update them
            if (len > (end - start)) {

                // Start will go to left so substract
                start = i - (len - 1) / 2;

                // End will go to right so add
                end = i + len / 2;
            }
        }

        // Return the substring from start to end
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int i, int i2, int n) {

        // Pointers to keep track
        int left = i, right = i2;

        // Traversal
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            // Decrease the left
            left--;
            // Increase the right
            right++;
        }

        // Finally return the length by giving right - left - 1
        return right - left - 1;
    }
}
