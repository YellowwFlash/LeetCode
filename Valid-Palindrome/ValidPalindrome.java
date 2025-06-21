public class ValidPalindrome {

    // Approach-1 -> Using another string as reference
    public static boolean isPalindrome(String s) {

        // Make a string builder to append current string
        StringBuilder initial = new StringBuilder();

        // First convert the current string to lower case
        s = s.toLowerCase();

        for (char ch : s.toCharArray()) {
            int character = (int) ch;

            // If the current character is from a to z, then only append it
            if (character > 96 && character <= 122)
                // Add into string builder after converting into lower case
                initial.append((char) character);
        }

        // Now simply reverse the inital
        StringBuilder reversed = initial.reverse();

        // Ṛeturn if they are equal or not
        return initial.toString().equals(reversed.toString());
    }

    // Approach-2 -> Using the two pointers approach
    public static boolean isPalindromePointers(String s) {

        // First convert the string into lowercase
        s = s.toLowerCase();

        // Make two pointers to check for palindrome
        int n = s.length();
        int left = 0, right = n - 1;

        // Start the traversal
        while (left < right) {

            // Find the ascii values of both the characters at right and left
            int leftChar = (int) s.charAt(left);
            int rightChar = (int) s.charAt(right);

            // If the left char is not from a-z, continue
            if (!Character.isLetterOrDigit(leftChar))
                // Simply increase the left pointer
                left++;

            // if the right char is not from a-z, continue
            else if (!Character.isLetterOrDigit(rightChar))
                // Simply decrease the right pointer
                right--;

            // If both of them are from a-z, check if they are equal or not
            else if (leftChar != rightChar)
                // If they arent equal, return false
                return false;

            // If they are equal, move the pointers
            else {
                left++;
                right--;
            }
        }

        return true;
    }
}
