import java.util.Stack;

public class ValidParentheses {

    // Approach-1 -> Using stack
    public static boolean isValid(String s) {

        // Create a stack for reference
        Stack<Character> stack = new Stack<>();

        // Start with string traversal
        for (char ch : s.toCharArray()) {

            // If the current character is any of the opeaning braces, add in stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // If not, then check for the corresponding closing bracket
            else if (ch == ')') {

                // Check if stack is not empty and the top is opeaning bracket, then remove it
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();

                // If not, directly return false as the order breaks
                else
                    return false;
            }

            else if (ch == '}') {

                // Check if stack is not empty and the top is opeaning bracket, then remove it
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();

                // If not, directly return false as the order breaks
                else
                    return false;
            }

            else if (ch == ']') {

                // Check if stack is not empty and the top is opeaning bracket, then remove it
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();

                // If not, directly return false as the order breaks
                else
                    return false;
            }

            // If any other operation than this, return false
            else
                return false;
        }

        // if the stack still has something, then they arent valid
        return stack.isEmpty();
    }
}
