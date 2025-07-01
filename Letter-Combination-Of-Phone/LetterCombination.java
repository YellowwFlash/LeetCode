import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    // Approach-1 -> Using recursion and backtracking
    public static List<String> letterCombination(String digits) {

        // If there are no digits, no combinations
        if (digits == null || digits.length() == 0)
            return null;

        // Result list
        List<String> result = new ArrayList<>();

        // String map for the characters
        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        // Recursively find the combinations
        combination(result, new StringBuilder(), digits, map, 0);

        // Return the result list
        return result;
    }

    private static void combination(List<String> result, StringBuilder stringBuilder, String digits, String[] map,
            int index) {

        // Base case: Add the current string in result if length is digits
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        // Find the current digit at index
        String current = map[digits.charAt(index) - '0'];

        // Loop through current string
        for (char ch : current.toCharArray()) {

            // Choice to add the current character
            stringBuilder.append(ch);

            // Recursively call for the next combination
            combination(result, stringBuilder, digits, map, index + 1);

            // Remove the current character for backtracking
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
