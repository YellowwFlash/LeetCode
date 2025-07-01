import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group {

    // Approach-1 -> Using sorting and mapping
    public static List<List<String>> groupAnagramsSort(String words[]) {

        // HashMap to keep track of the anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse all the words
        for (String word : words) {

            // Sort current word
            char temp[] = word.toCharArray();
            Arrays.sort(temp);

            // Conver back to string
            String sortedWord = new String(temp);

            // Now check in map for current string
            if (map.containsKey(sortedWord))
                // If it is present then add the word to the list
                map.get(sortedWord).add(word);

            // If current string is not present, add it to the map
            else
                map.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));

            /*
             * This if else can directly be done by another map function :
             * map.computeIfAbsent(sortedWord, k -> new ArrayList<String>()).add(word);
             */
        }

        // Return the final list which contains all map values(lowercase only)
        return new ArrayList<>(map.values());
    }

    // Approach-2 -> Using frequency count and map
    public static List<List<String>> groupAnagramsCount(String[] words) {

        // HashMap to keep track of the anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse all the words
        for (String word : words) {

            // Frequency array to keep track of the frequency
            int[] frequency = new int[26];

            // Add the frequency of current word to frequency array
            for (char c : word.toCharArray())
                frequency[c - 'a']++;

            // String for sorted order
            StringBuilder sorted = new StringBuilder();

            // Travese the frequency array for the sequence
            for (int i = 0; i < 26; i++) {

                // If the current frequency > 0, add the char
                while (frequency[i] > 0) {
                    // Add the char frequency times
                    sorted.append((char) ('a' + i));
                    // Reduce the frequency
                    frequency[i]--;
                }
            }

            // Compute in map for sorted word if absent
            map.computeIfAbsent(sorted.toString(), k -> new ArrayList<>()).add(word);
        }

        // Return the final arraylist containing all map values
        return new ArrayList<>(map.values());
    }
}