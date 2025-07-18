import java.util.HashMap;

public class CountSubarrays {

    // Approach-1 -> Using the atmost Approach
    public static int countSubarraysWithKDifferent(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    private static int atmost(int[] nums, int k) {

        // Find the length of the array
        int n = nums.length;

        // Define pointers, count of subarrays
        int left = 0, right = 0, count = 0;

        // Define a hashmap to keep track of the frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        while (right < n) {

            // Add the current element to the map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Find the validity of the window
            while (map.size() > k) {
                // Remove the leftmost element from the map
                map.put(nums[left], map.get(nums[left]) - 1);

                // Remove the element if the count is 0
                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);

                // Move the left pointer to shrink the window
                left++;
            }

            // Update the count of subarrays
            count += right - left + 1;

            // Move the right pointer
            right++;
        }

        // Return the count of subarrays with at most k different elements
        return count;
    }
}
