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

    // Approach-2 -> Using the xor operator(very hard to derive)
    public static int singleNumberXOR(int[] nums) {
        int result = 0;

        // Traverse the numbers by xoring the current number to the result
        for (int num : nums)
            result ^= num;

        // Return the final result containing the only single element
        return result;
    }

    // Approach-3(Specifically for sorted arrays) -> Using modified(index based) binary search (extremely hard to derive)
    public static int singleNumberBinarySearch(int[] nums) {
        int n = nums.length;

        // If the array has only one element, thats the single number
        if (n == 1)
            return nums[0];

        // If the first and second element are different, return it
        if (nums[0] != nums[1])
            return nums[0];

        // If the last and 2nd last element are different, return it
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        // Start the search from 2nd to 2nd last element as space
        int low = 1, high = n - 2;

        // Modified(indexing based) Binary search
        while (low <= high) {
            // Calculate the mid
            int mid = low + (high - low) / 2;

            // Check if the elements neighbouring mid are same or not
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                // Element at mid is out single element, return it
                return nums[mid];

            // Now in the left half with even odd pair thing, check for it
            else if ((mid % 2 != 0 && nums[mid - 1] == nums[mid]) || (mid % 2 == 0 && nums[mid + 1] == nums[mid])) {
                // The single number is in the right half
                low = mid + 1;
            }

            // Now with the odd even thing, the element will be in the left side
            else
                high = mid - 1;
        }

        return -1;
    }
}
