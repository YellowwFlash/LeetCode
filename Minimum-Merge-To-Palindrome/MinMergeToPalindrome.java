public class MinMergeToPalindrome {

    // Approach-1 -> Using the greedy balance technique
    public static int minMergeToPalindrome(int numbers[]) {
        int result = 0;
        int n = numbers.length;

        // Using two pointers for palindrome check
        int left = 0, right = n - 1;

        while (left < right) {

            // If both the numbers are equal, proceed to decrease the window
            if (numbers[left] == numbers[right]) {
                left++;
                right--;
            }

            // If not, then check at which pointer the value is less to merge

            // Check for the left pointer
            else if (numbers[left] < numbers[right]) {
                // Merge the element at left pointer with its next neighbour to balance
                numbers[left + 1] += numbers[left];
                result += 1; // Increment the result for a merge operation
                left++; // Decrese the window from left only to check further merges
            }

            // Check for the right pointer
            else {
                // Merge the element at right pointer with its previous neighbour to balance
                numbers[right - 1] += numbers[right];
                result += 1; // Increment the result for a merge operation
                right--; // Decrease the window from right only to check further merges
            }
        }

        return result;
    }
}
