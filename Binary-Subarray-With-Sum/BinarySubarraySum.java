import java.util.HashMap;

public class BinarySubarraySum {

    // Approach-1 -> Using the traditional prefixsum + hashmap
    public static int countBinarySubarraysHashMap(int[] nums, int goal) {

        // Define hashmap to keep track of the remainders
        HashMap<Integer, Integer> map = new HashMap<>();

        // Put 0 as the first entry since current remainder is 0
        map.put(0, 1);

        // Define prefix and count to keep track of answer
        int prefix = 0, count = 0;

        for (int num : nums) {

            // Add current num to prefix
            prefix += num;

            // Find the remainder
            int remainder = prefix - goal;

            // Find the count of remainder and add in count
            count += map.getOrDefault(remainder, 0);

            // Add the current sum in map
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        // Return count as the final answer
        return count;
    }

    // Approach-2 -> Using the atmost technique(for binary arrays only)
    public static int countBinarySubarraysAtmost(int[] nums, int goal) {

        return atmost(nums, goal) - atmost(nums, goal - 1);
    }

    // Function to find the classic sliding window implementation
    private static int atmost(int[] nums, int goal) {

        if (goal < 0)
            return 0;

        // Define length
        int n = nums.length;

        // Define pointers and sum
        int left = 0, right = 0, count = 0, sum = 0;

        // Traverse until the end
        while (right < n) {

            // Add current number to sum
            sum += nums[right];

            // Make the window valid
            while (sum > goal)
                sum -= nums[left++];

            // Update the count
            count += right - left + 1;

            // Move the right pointer
            right++;
        }

        // Return count as the final answer
        return count;
    }
}
