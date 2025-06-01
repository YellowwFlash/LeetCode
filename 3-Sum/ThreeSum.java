import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    // Approach-1 -> Using 3 loops
    public static List<List<Integer>> threeSum(int numbers[]) {
        Set<List<Integer>> list = new HashSet<>();
        int n = numbers.length;

        // This loop for the external first element
        for (int i = 0; i < n - 2; i++) {

            // This loop for the internal second element
            for (int j = i + 1; j < n - 1; j++) {

                // This loop for the internal third element
                for (int k = j + 1; k < n; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {

                        // Result set
                        List<Integer> result = Arrays.asList(numbers[i], numbers[j], numbers[k]);

                        // Sorting to find out if no duplicates are there
                        result.sort(null);

                        // If there isn't a duplicate, then only the result is added
                        list.add(result);
                    }
                }
            }
        }

        return new ArrayList<>(list);
    }

    // Approach-2 -> Optimized using loops
    public static List<List<Integer>> threeSumOptimised(int numbers[]) {
        Set<List<Integer>> set = new HashSet<>();
        int n = numbers.length;

        // Sort the array to track sum efficiently
        Arrays.sort(numbers);

        // First loop for the first element
        for (int i = 0; i < n - 2; i++) {

            // Duplicate skip for first element
            if (i > 0 && numbers[i] == numbers[i - 1])
                continue;

            // Using two pointers to find the rest of the two elements
            int j = i + 1, k = n - 1;
            
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];

                if (sum == 0) {
                    set.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));

                    // Excluding the duplicate elements
                    while (j < k && numbers[j] == numbers[j + 1])
                        j++;
                    while (k > j && numbers[k] == numbers[k - 1])
                        k--;
                    j++;
                    k--;

                } else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }

        return new ArrayList<>(set);
    }
}
