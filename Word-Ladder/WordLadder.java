import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    // Variation-1(Only steps) -> Using BFS
    public static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public static int ladderLength(String beginWord, String endWord, String[] wordList) {

        // Define a set of wordlist for storing all the words
        Set<String> wordSet = new HashSet<>();

        for (String word : wordList)
            wordSet.add(word);

        // If endWord is not present in the wordList, return 0
        if (!wordSet.contains(endWord))
            return 0;

        // Define a queue for BFS
        Queue<Pair> queue = new LinkedList<>();

        // Add the beginWord to the queue
        queue.add(new Pair(beginWord, 1));

        // Iterate until the queue is empty
        while (!queue.isEmpty()) {

            // Get the current Pair from the queue
            Pair pair = queue.poll();

            // Get the current word and its steps
            String word = pair.word;
            int steps = pair.steps;

            // Convert current word in char array
            char[] charArray = word.toCharArray();

            // Change the iterations of current word
            for (int i = 0; i < word.length(); i++) {

                // Get the original character
                char originalChar = charArray[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    // If the current and original chars are same, skip the iteration
                    if (originalChar == ch)
                        continue;

                    // Change the character to the new character
                    charArray[i] = ch;

                    // Create a new word by changing the character
                    String newWord = new String(charArray);

                    // If the new word is the endWord, return the steps
                    if (newWord.equals(endWord))
                        return steps + 1;

                    // If the new word is present in wordSet, add it in queue and remove from set
                    if (wordSet.contains(newWord)) {

                        // Remove the new word from the set
                        wordSet.remove(newWord);

                        // Add the new word to the queue
                        queue.add(new Pair(newWord, steps + 1));

                    }
                }

                // Reset the character to its original value
                charArray[i] = originalChar;
            }
        }

        // Return 0 since its impossible for this word
        return 0;
    }

}
