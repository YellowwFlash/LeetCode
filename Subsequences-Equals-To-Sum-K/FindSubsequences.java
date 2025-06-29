import java.util.ArrayList;
import java.util.List;

public class FindSubsequences {

    // Approach-1 -> Using recursion and backtracking
    public static List<List<Integer>> findSubsequences(int[] nums, int sum) {

        // Result List
        List<List<Integer>> result = new ArrayList<>();

        // Recursive function for finding the subsequences
        findSubsequencesUtil(nums, sum, 0, 0, new ArrayList<Integer>(), result);

        // Return the result List
        return result;
    }

    private static void findSubsequencesUtil(int[] nums, int sum, int index, int current,
            ArrayList<Integer> subsequence,
            List<List<Integer>> result) {

        // Base case : At index == n
        if (index == nums.length) {

            // Only add the subsequence if the current sum is equal to sum
            if (current == sum)
                result.add(new ArrayList<>(subsequence));

            return;
        }

        // Add the current number in choice
        subsequence.add(nums[index]);

        // Recursively call for the next subsequence
        findSubsequencesUtil(nums, sum, index + 1, current + nums[index], subsequence, result);

        // Remove the number added
        subsequence.remove(subsequence.size() - 1);

        // Recursively call for the next subsequence
        findSubsequencesUtil(nums, sum, index + 1, current, subsequence, result);
    }

    // Variation-1 -> Counting the subsequeces
    public static int countSubsequences(int[] nums, int current, int sum, int index, int n) {

        // Base case : At index == n
        if (index == n)
            // Check if the current is equal to sum, return 1 else 0
            return current == sum ? 1 : 0;

        // Consider choice of adding the current number
        int include = countSubsequences(nums, current + nums[index], sum, index + 1, n);

        // Consider the choice of excluding the current number
        int exclude = countSubsequences(nums, current, sum, index + 1, n);

        // Finally return the sum of both for total subsequeces
        return include + exclude;
    }

    // Variation-2 -> Checking if the subsequece exists or not
    public static boolean isSubsequenceExist(int[] nums, int sum, int current, int index, int n) {

        // Base case : At index == n
        if (index == n)
            // Check if the current is equal to sum, return true else false
            return current == sum;

        // If the inclusion of current number return true, we found a subsequece
        if (isSubsequenceExist(nums, sum, current + nums[index], index + 1, n) == true)
            return true;

        // If the exclusion of current number return true, we found a subsequece
        if (isSubsequenceExist(nums, sum, current, index + 1, n) == true)
            return true;

        // Return false since there is no subsequece right now
        return false;
    }
}
