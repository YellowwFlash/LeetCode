public class RemoveParentheses {

    // Approach-1 -> Using the valid parentheses idea 
    public static String removeParentheses(String s) {

        // Result string
        StringBuilder result = new StringBuilder();

        // Counter for reference
        int count = 0;

        for (char ch : s.toCharArray()) {

            // If the ch is ')', decrease the count
            if (ch == ')')
                count--;

            // Before '(', if count is non zero, append the ch
            if (count != 0)
                result.append(ch);

            // If ch is '(', increase the count
            if (ch == '(')
                count++;
        }

        // Finally return the result string
        return result.toString();
    }
}