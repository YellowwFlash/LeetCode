import java.util.HashMap;

public class SubarraySumEqualsK {

    // Approach-1 -> Using prefix sum and hashmap
    public static int subarraySumEqualsKPrefixHashMap(int[] nums, int k) {
        int answer = 0;

        // A hashmap to store the frequencies of the remainders
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store 0 as the first remainder
        map.put(0, 1);

        // Iterate to follow the pattern of finding the remainder
        int prefixSum = 0;
        for (int number : nums) {
            // Include number in current sum
            prefixSum += number;

            // The current remainder should be k less in current sum
            int remainder = prefixSum - k;

            // If the remainder is already in the map, it means we have found a subarray sum
            answer += map.getOrDefault(remainder, 0);

            // Put the current sum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return answer;
    }
}
