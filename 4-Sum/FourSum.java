import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    // Approach-1 -> Using 4 loops
    public static List<List<Integer>> fourSumLoops(int[] nums, int target) {

        int n = nums.length;

        // Result List
        Set<List<Integer>> result = new HashSet<>();

        // First loop for the first element
        for (int i = 0; i < n - 3; i++) {
            // Second loop for the second element
            for (int j = i + 1; j < n - 2; j++) {
                // Third loop for the third element
                for (int k = j + 1; k < n - 1; k++) {
                    // Fourth loop for the final element
                    for (int l = k + 1; l < n; l++) {
                        // Check if the sum of the four elements is equal to the target
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target)
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    // Approach-2 -> Using the optimized 3sum format
    public static List<List<Integer>> fourSum(int nums[], int target) {

        int n = nums.length;

        // Result List
        Set<List<Integer>> result = new HashSet<>();

        // Sort the array
        Arrays.sort(nums);

        // External loop for the first element
        outer: for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1])
                continue outer;

            // Second loop for the second element
            inner: for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue inner;

                int k = j + 1, l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];

                    // Check if the sum and target are same
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // Skip all the duplicates for both k and l
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (l > k && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
