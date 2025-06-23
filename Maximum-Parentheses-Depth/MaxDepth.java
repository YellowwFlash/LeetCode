public class MaxDepth {

    // Approach-1 -> Using valid parentheses hack
    public static int maxDepth(String s) {

        int maxDepth = -1, currentDepth = 0;

        for (char ch : s.toCharArray()) {

            // If opeaning braces, the depth will increase
            if (ch == '(') {
                currentDepth++;
                // Update the maxDepth
                maxDepth = Math.max(maxDepth, currentDepth);
            }

            // If closing braces, the depth will decrease
            else if (ch == ')')
                currentDepth--;

            else
                continue;

        }

        return maxDepth;
    }
}
