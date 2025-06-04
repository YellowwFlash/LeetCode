import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {

    // Approach-1 -> Using the prefix sum and hashmap
    public static int SubarraySumDivisibleByKHashMap(int numbers[], int k) {
        int answer = 0;

        // A map to store the modulo and its frequency
        Map<Integer, Integer> mods = new HashMap<>();

        // Since the sum is currently zero, add it to map
        int sum = 0;
        mods.put(0, 1); // Placing the zero sum as a frequency

        // Traverse the numbers and keep a running updation
        for (int number : numbers) {
            // Add the number to sum
            sum += number;

            // Take the mod taking care of the negative sum
            int mod = (sum % k + k) % k;

            // If the mod is already present in the map, it means we have found a subarray.
            answer += mods.getOrDefault(mod, 0);

            // Put the value of current mod in the mods map
            mods.put(mod, mods.getOrDefault(mod, 0) + 1);
        }

        return answer;
    }

    // Approach-2 -> Optimized space and time variation
    public static int subarraySumEqualsKPrefixHashMapOptimized(int[] nums, int k) {

        // Instead of map, since the remainders will be upto k, make an array of k size
        int map[] = new int[k];
        
        // Current sum as 0 with 1 frequency
        map[0] = 1;

        int count = 0, sum = 0;

        // Iteration to formulate the output
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (mod < 0)
                mod += k;
            count += map[mod]++;
        }

        return count;
    }
}
