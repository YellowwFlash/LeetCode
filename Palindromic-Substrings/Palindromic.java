import java.util.ArrayList;
import java.util.List;

public class Palindromic {

    // Approach-1 -> Finding all substrings and finding which is palindromic
    public static int palindromicSubstringsLoops(String string) {

        int n = string.length();

        // Result counter
        int result = 0;

        // List to keep all the substrings
        List<String> list = new ArrayList<>();

        // Calculation of all substrings
        for (int i = 0; i < n; i++)
            // Internal loop to extend boundaries till n
            for (int j = i; j < n; j++)
                // Add the substring to the list
                list.add(string.substring(i, j + 1));

        // Traverse the list to find palindromic substrings
        for (String s : list)
            // Check if the substring is equal to its reverse
            if (s.equals(new StringBuilder(s).reverse().toString()))
                // Increase the counter since its a palindromic substring
                result++;

        // Return the final count of total palindromic substrings
        return result;
    }

    // Approach-2 -> Using the expand-around-center technique
    public static int palindromicSubstringsExpandAroundCenter(String string) {

        int n = string.length();

        // Result counter
        int result = 0;

        // Traverse the string
        for (int i = 0; i < n; i++) {

            // Odd length palindromic substrings finder
            int odd = expandAroundCenter(string, i, i, n);

            // Even length palindromic substrings finder
            int even = expandAroundCenter(string, i, i + 1, n);

            // Add the total substrings inside result
            result += odd + even;
        }

        // Return the final result
        return result;
    }

    private static int expandAroundCenter(String string, int i, int j, int n) {

        int counter = 0;

        // Pointers to keep track
        int left = i, right = j;

        // Traversal and expansion around center
        while (left >= 0 && right < n && string.charAt(right) == string.charAt(left)) {

            // Increase the right
            right++;
            // Decrease the left
            left--;

            // Increase the counter since every iteration gives new palindromic substring
            counter++;
        }

        // Return the counter to give total palindromic substrings
        return counter;
    }
}
