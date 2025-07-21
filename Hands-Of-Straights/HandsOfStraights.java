import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class HandsOfStraights {

    // Approach-1 -> Using TreeMap
    public static boolean handsOfStraights(int[] hands, int k) {

        // If the hands are not divisible by k, return false
        if (hands.length % k != 0)
            return false;

        // Define a tree map for sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Add all the hand values to the map
        for (int hand : hands)
            map.put(hand, map.getOrDefault(hand, 0) + 1);

        // Iterate until the map is not empty
        while (!map.isEmpty()) {

            // Get the first element from the map
            int first = map.firstKey();

            // Starting from first key, go till k times
            for (int i = first; i < first + k; i++) {

                // If map does not have that consecutive value, return false
                if (!map.containsKey(i)) {
                    return false;
                } else {

                    // Decrement the count of the value
                    map.put(i, map.get(i) - 1);

                    // If the count becomes 0, remove it from the map
                    if (map.get(i) == 0)
                        map.remove(i);
                }
            }
        }

        // Return true since all the consecutive hands are possible
        return true;
    }

    // Approach-2 -> Using Sorting and HashMap
    public static boolean handsOfStrainghtsHashMap(int[] hands, int k) {

        // If the hands are not divisible by k, return false
        if (hands.length % k != 0)
            return false;

        // Define a HashMap for sorted order
        HashMap<Integer, Integer> map = new HashMap<>();

        // Add all the hand values to the map
        for (int hand : hands)
            map.put(hand, map.getOrDefault(hand, 0) + 1);

        // Define a list for sorted values
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        // Iterate until the map is not empty
        for (int key : list) {

            int count = map.getOrDefault(key, 0);

            if (count < 1)
                continue;

            // Find the elements for the groupsize
            for (int i = 0; i < k; i++) {
                if (map.getOrDefault(i, 0) < count)
                    return false;
                else
                    map.put(key + i, map.get(key + i) - count);

            }
        }

        // Return true since all the consecutive hands are possible
        return true;
    }
}
