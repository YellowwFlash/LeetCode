import java.util.ArrayList;
import java.util.List;

public class GenerateSubsequences {

    // Approach-1 -> Using recursion and backtracking
    public static List<List<Integer>> generateSubsequences(int[] nums) {

        // Result List
        List<List<Integer>> result = new ArrayList<>();

        // Recursively find all the subsequences
        findSubsequences(result, new ArrayList<Integer>(), 0, nums, nums.length);

        // Return the final result
        return result;
    }

    private static void findSubsequences(List<List<Integer>> result, ArrayList<Integer> subsequence, int index,
            int[] nums, int n) {

        // Base case : Index reaching n
        if (index == n) {

            // Add the current subsequence to result
            result.add(new ArrayList<>(subsequence));

            return;
        }

        // Choosing the choice of adding the number at ith index
        subsequence.add(nums[index]);

        // Recursively call for the next subsequence
        findSubsequences(result, subsequence, index + 1, nums, n);

        // Remove the added number and choose the choice for not adding the number
        subsequence.remove(subsequence.size() - 1);

        // Recursively call for the next subsequence
        findSubsequences(result, subsequence, index + 1, nums, n);
    }

    // Approach-2 -> Using bit manipulation
    public static List<List<Integer>> findSubsequencesBit(int[] nums) {

        int n = nums.length;

        // First find the total number of possible subsets
        int total = 1 << n;

        // Result list
        List<List<Integer>> result = new ArrayList<>();

        // Loop through from 0 till total
        for (int i = 0; i < total; i++) {

            // subset storing list
            List<Integer> subset = new ArrayList<>();

            // Reference number to store current
            int ref = i;

            // Loop through nums
            for (int j = 0; j < nums.length; j++) {

                // Check if the rightmost bit is set, then add current
                if ((ref & 1) == 1)
                    subset.add(nums[j]);

                // right shift ref(divide it by 2)
                ref >>= 1;
            }

            // Add the current subset list to result
            result.add(subset);
        }

        // Return the final subset list
        return result;
    }
}
