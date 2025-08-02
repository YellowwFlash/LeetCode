import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rearrange {

    // Approach-1 -> Using greedy sorting and hashmap
    public static long rearrange(int[] basket1, int[] basket2) {

        // Hashmap to store the difference of the frequencies of elements in baskets
        HashMap<Integer, Integer> map = new HashMap<>();

        // List to keep track of the elements worthy of rearrangement
        List<Integer> list = new ArrayList<>();

        // Define min to keep track of the global minimum for indirect swapping
        int min = Integer.MAX_VALUE;

        // Add the frequencies of elements in basket1 to the hashmap
        for (int fruit : basket1) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            min = Math.min(min, fruit);
        }

        // Remove the frequencies of elements in basket2 from the hashmap
        for (int fruit : basket2) {
            map.put(fruit, map.getOrDefault(fruit, 0) - 1);
            min = Math.min(min, fruit);
        }

        // Iterate through the hashmap to find the elements worthy of rearrangement
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // Get the value from map
            int value = entry.getValue();

            // If the value is odd, there cannot be rearrangement since its impossible case
            if (value % 2 != 0)
                return -1;

            // Add the fruit's value half the time of its frequency because the fruit is
            // swappable that many times
            for (int i = 0; i < Math.abs(value) / 2; i++)
                list.add(entry.getKey());
        }

        // Sort the list to get the minimum values (greedy sorting)
        Collections.sort(list);

        // Keep track of the answer to return
        long ans = 0;

        // Traverse only half of the list because the elements will be swapped with the
        // rest half
        for (int i = 0; i < list.size() / 2; i++)

            // Find the min of direct and indirect swapping and add it to the answer
            ans += Math.min(list.get(i), min * 2L);

        // Return answer as the final output
        return ans;
    }
}
