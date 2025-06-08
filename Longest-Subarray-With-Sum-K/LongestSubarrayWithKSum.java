import java.util.HashMap;

public class LongestSubarrayWithKSum {

    // Approach-1 -> Using hashing
    public static int longestSubarrayWithKSumHashMap(int[] nums, int k) {
        int n = nums.length;

        // Create HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLength = 0;

        // Array traversal
        for (int i = 0; i < n; i++) {

            // Calculate the current prefix sum
            prefixSum += nums[i];

            // if the current sum is k then update max length
            if (prefixSum == k)
                maxLength = Math.max(maxLength, i + 1); // +1 because we are considering the subarray from 0 to i

            int remainder = prefixSum - k;

            // Check for the remainder in map
            if (map.containsKey(remainder)) {
                int length = i - map.get(remainder);
                maxLength = Math.max(maxLength, length);
            }

            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }

        return maxLength;
    }

    // Approach-2 -> Using two pointers(Only for positives)
    public static int longestSubarrayWithKSumTwoPointers(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0, left = 0, currentSum = nums[0], right = 0;

        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n)
                currentSum += nums[right];
        }

        return maxLength;
    }
}
