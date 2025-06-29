import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // Approach-1 -> Using recursion and backtracking
    public static List<String> generateParentheses(int n) {

        // Result List
        List<String> result = new ArrayList<>();

        // Recursively call for the valid parenthesis
        generateParenthesesUtil(result, new StringBuilder(), n, n, n);

        // Return the final List
        return result;
    }

    private static void generateParenthesesUtil(List<String> result, StringBuilder string, int open, int close, int n) {

        // If both the open and close are 0, the string will be of 2n length
        if (string.length() == 2 * n) {

            // Add the string in the list
            result.add(string.toString());

            return;
        }

        // If the open braces are > 0, then they can be added
        if (open > 0) {

            // Append ( to current string
            string.append('(');

            // Recursively call for the next sequence
            generateParenthesesUtil(result, string, open - 1, close, n);

            // Remove the current choice for backtracking
            string.deleteCharAt(string.length() - 1);
        }

        // if the closing braces are > opeaning, they can be added
        if (close > open) {

            // Append ) to current string
            string.append(')');

            // Recursively call for the next sequence
            generateParenthesesUtil(result, string, open, close - 1, n);

            // Remove the current choice for backtracking
            string.deleteCharAt(string.length() - 1);
        }
    }
}
