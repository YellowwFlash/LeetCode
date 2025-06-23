import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {

    // Approach-1 -> Using hashmap to map characters
    public static boolean isIsomorphicFrequency(String s, String t) {

        // If they have different length, return false
        if (s.length() != t.length())
            return false;

        // HashMap and set for keeping the track
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        // Start iterating the characters of strings together
        for (int i = 0; i < s.length(); i++) {

            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // First check if the map has any character mapped to sc
            if (map.containsKey(sc)) {
                // Check in set if there is tc, return false
                if (map.get(sc) != tc)
                    return false;
            }

            // If there is not character mapped to sc, then map it
            else {
                // Check if tc is already mapped to any other character
                if (set.contains(tc))
                    return false;

                // Add sc and tc in the map
                map.put(sc, tc);

                // Add tc to set
                set.add(tc);
            }
        }

        return true;
    }
}
