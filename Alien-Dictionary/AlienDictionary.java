import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    // Approach-1 -> Using BFS and Topological Sort
    public List<Character> alienOrder(String[] words, int n) {

        // Define a graph to map all the characters with neighbors
        List<List<Integer>> graph = new ArrayList<>();

        // Define an array to store the indegree of each character
        int[] indegree = new int[n];

        // Initialize the graph
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // Traverse all the words and find the dependency chars
        for (int i = 0; i < n - 1; i++) {

            // Get two consecutive words for finding dependency
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the min length of the two words to iterate
            int minLen = Math.min(word1.length(), word2.length());

            // Iterate for minlength and find the dependency chars
            for (int j = 0; j < minLen; j++) {

                // Get the chars from the words
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                // If the char in word1 differs word2, add dependency and break
                if (ch1 != ch2) {
                    graph.get(ch1 - 'a').add(ch2 - 'a');
                    indegree[ch2 - 'a']++;
                    break;
                }
            }
        }

        // Define a queue to store the chars with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        // Traverse the indegree and add 0 indegree chars to queue
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        // Define a list of chars to store the topological sort
        List<Character> order = new ArrayList<>();

        // Perform BFS and add the chars to the result list
        while (!queue.isEmpty()) {

            // Get the char from the queue
            int charIdx = queue.poll();
            order.add((char) (charIdx + 'a'));

            // Get the neighbors of the char
            for (int neighbor : graph.get(charIdx)) {

                // Reduce the indegree of the neighbor
                indegree[neighbor]--;

                // If indegree becomes 0, add to queue
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        // Return the topologically ordered characters
        return order;
    }
}
