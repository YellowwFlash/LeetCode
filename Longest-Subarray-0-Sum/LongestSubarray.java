import java.util.HashMap;

public class LongestSubarray {

    // Approach-1 -> Using the prefix sum and hashmap
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int longestLength = 0;

        // HashMap to store the prefix sum along with their indices
        HashMap<Integer, Integer> map = new HashMap<>(); // key: prefix sum, value: index

        // Current prefix sum
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {

            int num = nums[i];

            // Add the current number to prefix sum
            prefixSum += num;

            // Check if the prefix sum is zero
            if (prefixSum == 0)
                // The longest length is just 1 greater than index
                longestLength = i + 1;
            // If not then, is there a prefix sum existing in map already
            else if (map.containsKey(prefixSum))
                // If map has the prefix sum, then update the max length
                longestLength = Math.max(longestLength, i - map.get(prefixSum));

            // If none, then add the prefix sum along with their index
            else
                map.put(prefixSum, i);
        }

        return longestLength;
    }
}
