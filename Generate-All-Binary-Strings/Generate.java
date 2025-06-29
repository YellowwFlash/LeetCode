import java.util.ArrayList;
import java.util.List;

public class Generate {

    // Approach-1 -> Using recursion and backtracking
    public static List<String> generateAll(int n) {

        // Result List
        List<String> result = new ArrayList<>();

        // Generate all combinations
        generateAllUtil(result, new StringBuilder(), n);

        return result;
    }

    private static void generateAllUtil(List<String> result, StringBuilder string, int n) {

        // Base case : When index and n are equal, add string in result
        if (string.length() == n) {

            // Add the string
            result.add(string.toString());

            return;
        }

        // Append 0 in string
        string.append("0");

        // Call for the next iteration
        generateAllUtil(result, string, n);

        // Remove the choice of 0 to backtrack
        string.deleteCharAt(string.length() - 1);

        // Append 1 in string
        string.append("1");

        // Call for the next iteration
        generateAllUtil(result, string, n);

        // Remove the choice of 1 to backtrack
        string.deleteCharAt(string.length() - 1);
    }

    // Variation-1 -> No consecutive 0s
    private static void generateAllUtilNoConsecutiveZeros(List<String> result, StringBuilder string, int n) {

        // Base case : When index and n are equal, add string in result
        if (string.length() == n) {

            // Add the string
            result.add(string.toString());

            return;
        }

        // Check if the length of string is 0 and previous character is non 0
        if (string.length() == 0 || string.charAt(string.length() - 1) != '0') {

            // Append 0 in string
            string.append("0");

            // Call for the next iteration
            generateAllUtilNoConsecutiveZeros(result, string, n);

            // Remove the choice of 0 to backtrack
            string.deleteCharAt(string.length() - 1);
        }

        // Append 1 in string
        string.append("1");

        // Call for the next iteration
        generateAllUtilNoConsecutiveZeros(result, string, n);

        // Remove the choice of 1 to backtrack
        string.deleteCharAt(string.length() - 1);
    }

    // Variation-2 -> No consecutive 1s
    private static void generateAllUtilNoConsecutiveOnes(List<String> result, StringBuilder string, int n) {

        // Base case : When index and n are equal, add string in result
        if (string.length() == n) {

            // Add the string
            result.add(string.toString());

            return;
        }

        // Append 0 in string
        string.append("0");

        // Call for the next iteration
        generateAllUtilNoConsecutiveOnes(result, string, n);

        // Remove the choice of 0 to backtrack
        string.deleteCharAt(string.length() - 1);

        // Check if the length of string is 0 and previous character is not 1
        if (string.length() == 0 || string.charAt(string.length() - 1) != '1') {

            // Append 1 in string
            string.append("1");

            // Call for the next iteration
            generateAllUtilNoConsecutiveOnes(result, string, n);

            // Remove the choice of 1 to backtrack
            string.deleteCharAt(string.length() - 1);
        }
    }
}
