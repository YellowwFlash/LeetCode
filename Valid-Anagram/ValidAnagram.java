import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    // Approach-1 -> Using internal sorting technique
    public static boolean isAnagramSorting(String s1, String s2) {

        // If length of string isnt same, they arent anagrams
        if (s1.length() != s2.length())
            return false;

        // Sort both of the strings
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Now simply check if both of the arrays are equal or not
        return Arrays.equals(charArray1, charArray2);
    }

    // Approach-2 -> Using the frequency technique
    public static boolean isAnagramFrequency(String s1, String s2) {

        // If length of string isnt same, they arent anagrams
        if (s1.length() != s2.length())
            return false;

        // Make an array of 26 size for all letters
        int[] count = new int[26];

        // Start with s1 and add all the frequency in array
        for (char ch : s1.toCharArray())
            count[ch - 'a']++;

        // Remove the frequency using s2 from array
        for (char ch : s2.toCharArray())
            count[ch - 'a']--;

        // Iterate the array and check if all of the count is 0
        for (int frequency : count)
            // if the frequency is not 0, means they are not anagrams
            if (frequency != 0)
                return false;

        return true;
    }

    // Approach-3 -> Using a hashmap (if strings has unicode characters)
    public static boolean isAnagramHashMap(String s1, String s2) {

        // If length of string isnt same, they arent anagrams
        if (s1.length() != s2.length())
            return false;

        // Make a frequency map
        HashMap<Character, Integer> map = new HashMap<>();

        // For string s1, add the frequency in map
        for (char ch : s1.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        // For string s2, remove the frequency from map
        for (char ch : s2.toCharArray()) {
            // First if the map doesnt contain current character, return false
            if (!map.containsKey(ch))
                return false;
            // else remove the frequency from map
            map.put(ch, map.get(ch) - 1);

            // Remove the whole entry if the frequency is 0
            if (map.get(ch) == 0)
                map.remove(ch);
        }

        /*
         * // Ṇow traverse the map to find out if all the frequencies are 0
         * for (int frequency : map.values())
         * // if the frequency is not 0, means they are not anagrams
         * if (frequency != 0)
         * return false;
         */

        return map.isEmpty();
    }
}
