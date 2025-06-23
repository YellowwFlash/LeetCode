import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Sort {

    // Approach-1 -> Using priorityqueue
    public static class Pair {
        char character;
        int frequency;

        Pair(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }

    public static String sortCharactersPQ(String string) {

        // Count the occurrences in hash array (lowercase and uppercase only)
        int[] hash = new int[128];

        // Count the frequency
        for (char ch : string.toCharArray())
            hash[ch]++;

        // Priority queue for internal sorting
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.frequency, b.frequency));

        // Add the characters and frequency in priorityqueue
        for (int i = 0; i < 128; i++)
            // Only add if the character frequency is non zero
            if (hash[i] != 0)
                queue.add(new Pair((char) i, hash[i]));

        // Result string
        StringBuilder result = new StringBuilder();

        // Traverse the queue and find the sorted characters
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            char character = pair.character;

            for (int i = 0; i < pair.frequency; i++)
                result.append(character);
        }

        // Return the result string
        return result.toString();
    }

    // Approach-2 -> Using Bucket sorting technique
    @SuppressWarnings("unchecked")
    public static String sortCharactersBucket(String string) {

        // Count the occurrences and max frequency
        int maxFrequency = 0;
        int[] hash = new int[128];

        for (char ch : string.toCharArray()) {
            // Add the frequency
            hash[ch]++;
            // Find the maxFrequency
            maxFrequency = Math.max(maxFrequency, hash[ch]);
        }

        // Make a bucket based on frequency
        List<Character>[] bucket = new ArrayList[maxFrequency + 1];

        // Add the characters based on the frequency
        for (int i = 0; i < 128; i++) {
            // If the current frequency is non zero, then only proceed
            if (hash[i] != 0) {
                // Add the character to the bucket
                if (bucket[hash[i]] == null)
                    bucket[hash[i]] = new ArrayList<>();
                bucket[hash[i]].add((char) i);
            }
        }

        // Result string
        StringBuilder result = new StringBuilder();

        // Traverse the bucket for final sorting of strings
        for (int i = 0; i < bucket.length; i++) {

            // Only proceed if the current bucket is not null
            if (bucket[i] != null) {
                // Add the character to the result string
                for (char ch : bucket[i])
                    // Append the character its frequency times
                    for (int j = 0; j < i; j++)
                        result.append(ch);
            }
        }

        // Return the result string
        return result.toString();
    }
}
