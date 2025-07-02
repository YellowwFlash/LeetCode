import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {

    // Approach-1 -> Using recursion and backtracking
    public static List<List<String>> partitionPalindrome(String word) {

        // Result list
        List<List<String>> result = new ArrayList<>();

        // If the word's length is 1, return it simply
        if (word.length() == 1) {
            result.add(new ArrayList<>(Arrays.asList(word)));
            return result;
        }

        // Recursively find the partitions for the palindromes possible
        partitions(result, new ArrayList<String>(), word, 0, word.length());

        // Return the final result list
        return result;
    }

    private static void partitions(List<List<String>> result, ArrayList<String> palindromes, String word, int index,
            int n) {

        // Base case: When index reaches n
        if (index == n) {

            // Add the palindromes to result list
            result.add(new ArrayList<>(palindromes));
            return;
        }

        // Loop through index till n
        for (int i = index; i < n; i++) {

            // Find the current word is a substring or not
            if (isPalindrome(word, index, i)) {

                // Add the current substring to palindrome
                palindromes.add(word.substring(index, i + 1));

                // Recursively find the next palindrom partitioning
                partitions(result, palindromes, word, i + 1, n);

                // Remove the last added thing to backtrack
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String word, int start, int end) {

        // Find if its palindrome
        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--))
                return false;
        }

        return true;
    }
}
