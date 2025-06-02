import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Approach-1 -> Using two loops
    public static int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        // External loop for the first element
        for (int i = 0; i < n - 1; i++)
            // Internal loop for the second element
            for (int j = i + 1; j < n; j++)
                // Check if the sum of the two elements is equal to the target
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };

        return null;
    }

    // Approach-2 -> Using hashing
    public static int[] twoSumHashMap(int[] nums, int target) {

        int n = nums.length;

        // Using map to map the indexes to values
        Map<Integer, Integer> map = new HashMap<>();

        // Traversal to find the values
        for (int i = 0; i < n; i++) {
            int current = map.getOrDefault(target - nums[i], -1);
            if (current != -1)
                return new int[] { current, i };
            map.put(nums[i], i);
        }

        return null;
    }
}