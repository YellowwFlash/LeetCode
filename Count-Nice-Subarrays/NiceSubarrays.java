import java.util.HashMap;

public class NiceSubarrays {

    // Approach-1 -> Using prefix count and hashmap
    public static int countNiceSubarraysHashMap(int[] nums, int k) {

        // Define count and prefix odd count
        int count = 0, prefix = 0;

        // Define hashmap to keep track of odd counts
        HashMap<Integer, Integer> map = new HashMap<>();

        // Put 0 as the first remainder
        map.put(0, 1);

        for (int num : nums) {

            // Add the odd number to prefix count
            prefix += (num & 1);

            // Find the remainder of the count
            int remainder = prefix - k;

            // Update the count
            count += map.getOrDefault(remainder, 0);

            // Add the current prefix count to map
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        // Return count as the final answer
        return count;
    }

    // Approach-2 -> By converting array into binary and using atmost logic
    public static int countNiceSubarraysBinaryLogic(int[] nums, int k) {

        return atmost(nums, k) - atmost(nums, k - 1);
    }

    private static int atmost(int[] nums, int goal) {

        if (goal < 0)
            return 0;

        // Define pointers, count and sum
        int left = 0, right = 0, count = 0, sum = 0, n = nums.length;

        while (right < n) {

            // Add the current number to sum
            sum += (nums[right] & 1);

            // Validate the window
            while (sum > goal)
                sum -= (nums[left++] & 1);

            // Update the count
            count += right - left + 1;

            // Move the right pointer
            right++;
        }

        // Return count as the final answer
        return count;
    }
}
