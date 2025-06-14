import java.util.HashMap;

public class SubarrayXorEqualsK {

    // Approach-1 -> Using the prefix xor and hashmap
    public static int subarrayXorEqualsK(int[] nums, int k) {
        int count = 0, n = nums.length;

        // Hashmap to store the values of xor with their counts
        HashMap<Integer, Integer> map = new HashMap<>();
        // Init the map with 0 xor and 1 count
        map.put(0, 1);

        // Init a prefix xor for the nums
        int prefixXor = 0;

        // Traverse the current array
        for (int i = 0; i < n; i++) {
            // Update the prefix xor
            prefixXor ^= nums[i];

            // remainder xor
            int remainderXor = prefixXor ^ k;

            // If the remainder xor is in the map, then count should be increased
            count += map.getOrDefault(remainderXor, 0);

            // Add the current xor to map
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
