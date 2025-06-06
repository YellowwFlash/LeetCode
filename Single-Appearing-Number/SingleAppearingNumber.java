import java.util.HashMap;
import java.util.Map;

public class SingleAppearingNumber {

    // Approach-1 -> Using HashMap (Intuitive approach)
    public static int singleNumberHashMap(int[] nums) {

        // Declare a frequency map to keep track
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array for maintaining the frequency
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Traverse the map to find the single number
        for (Map.Entry<Integer, Integer> entryMap : map.entrySet())
            if (entryMap.getValue() == 1)
                return entryMap.getKey();

        return -1;
    }

    // Approach-2 -> Using the xor operator(very hard to derieve)
    public static int singleNumberXOR(int[] nums) {
        int result = 0;

        // Traverse the numbers by xoring the current number to the result
        for (int num : nums)
            result ^= num;

        // Return the final result containing the only single element
        return result;
    }
}
