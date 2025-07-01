import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

    // Approach-1 -> Using recursion
    public static List<Integer> subsetSum(int[] nums) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Find the all possible sums of subsets recursively
        subsetSumRecursive(nums, 0, 0, result, nums.length);

        // Sort the current result
        Collections.sort(result);

        // Return the final result list
        return result;
    }

    private static void subsetSumRecursive(int[] nums, int index, int current, List<Integer> result, int length) {

        // Base case: At index == length
        if (index == length) {

            // Add the current sum in result
            result.add(current);

            return;
        }

        // Choice to add the number and move the index
        subsetSumRecursive(nums, index + 1, current + nums[index], result, length);

        // Choice to skip the number and move the index
        subsetSumRecursive(nums, index + 1, current, result, length);
    }
}
