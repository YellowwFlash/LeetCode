import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // Approach-1 -> Using recursion
    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        // Result list
        List<List<Integer>> result = new ArrayList<>();

        // Recursively find the result combinations
        findCombinations(nums, target, 0, result, new ArrayList<Integer>(), 0);

        // Return the final list
        return result;
    }

    private static void findCombinations(int[] nums, int target, int current, List<List<Integer>> result,
            ArrayList<Integer> combination, int index) {

        // Early termination -> if current sum > target sum return
        if (current > target)
            // Since all the numbers are +ve, its best not to explore further
            return;

        // Base case: At index == nums.length
        if (index == nums.length) {

            // If the current sum is equal to target
            if (current == target) {
                // Add the current combination as answer in result
                result.add(new ArrayList<>(combination));
            }

            return;
        }

        // Choice-1 -> Add current number & stay at index for further use
        combination.add(nums[index]);
        // Recursively call for the further combinations
        findCombinations(nums, target, current + nums[index], result, combination, index);

        // Choice-2 -> Not add the current number and move to the next index
        combination.remove(combination.size() - 1);
        // Recursively call for the further combinations
        findCombinations(nums, target, current, result, combination, index + 1);
    }

    // Variation-1 -> All numbers must be used once and only uniques are allowed
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {

        // Sort the nums to easy duplicates handling
        Arrays.sort(nums);

        // Result list as set for unique storage
        List<List<Integer>> result = new ArrayList<>();

        // Recursively find all the possible combinations
        findCombinations2(nums, target, 0, result, new ArrayList<Integer>(), 0, nums.length);

        // Return the final result list
        return new ArrayList<>(result);
    }

    private static void findCombinations2(int[] nums, int target, int current, List<List<Integer>> result,
            ArrayList<Integer> combination, int index, int length) {

        // Base case: Check of curret sum = target sum and add combination
        if (current == target) {
            result.add(new ArrayList<>(combination));

            return;
        }

        // Traverse from index till end to find all combinations
        for (int i = index; i < length; i++) {

            // Skip all the duplicates
            if (i > index && nums[i] == nums[i - 1])
                continue;

            // Early pruning for current sum > target
            if (current > target)
                break;

            // Choice of adding current number
            combination.add(nums[i]);

            // Recursively call for the next iteration
            findCombinations2(nums, target, current + nums[i], result, combination, i + 1, length);

            // Remove the current number for backtracking and choice of skipping
            combination.remove(combination.size() - 1);
        }
    }

    // Variation-2 -> No given numbers. For sum n with k numbers and return all
    public static List<List<Integer>> combinationSum3(int k, int n) {

        // Result list
        List<List<Integer>> result = new ArrayList<>();

        // Number used would be 1 to 9
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // Recursively call for finding the combinations
        findCombinations3(nums, n, k, 0, result, new ArrayList<Integer>(), 0);

        // Return the final list
        return result;
    }

    private static void findCombinations3(int[] nums, int target, int k, int current, List<List<Integer>> result,
            ArrayList<Integer> combination, int index) {

        // If the length of current combination is k
        if (combination.size() == k) {

            // if the sum of the combination = target, add it in result
            if (current == target)
                result.add(new ArrayList<>(combination));

            return;
        }

        // At index == length, check for the validation
        if (index == nums.length) {

            // if the sum of the combination = target, add it in result
            if (combination.size() == k && current == target)
                result.add(new ArrayList<>(combination));

            return;
        }

        // If the current sum exceeds the target, return
        if (current > target)
            return;

        // Choose to add the current number
        combination.add(nums[index]);
        // Recursively call for the remaining combination
        findCombinations3(nums, target, k, current + nums[index], result, combination, index + 1);

        // Choose to skip the number
        combination.remove(combination.size() - 1);
        // Recursively call for the remaining combination
        findCombinations3(nums, target, k, current, result, combination, index + 1);
    }
}
