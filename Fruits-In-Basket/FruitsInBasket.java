import java.util.HashMap;

public class FruitsInBasket {

    // Approach-1 -> Using sliding window and hashmap
    public static int maxFruitsInBasket(int[] fruits) {

        // Define a hashmap to keep track of frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        // Define length
        int n = fruits.length;

        // Define the pointers and maxlength
        int left = 0, right = 0, maxlength = 0;

        // Traverse until the end
        while (right < n) {

            int rightFruit = fruits[right];

            // Add the fruit at right to map
            map.put(rightFruit, map.getOrDefault(rightFruit, 0) + 1);

            // If the size of map exceeds 2, the window is incorrect
            while (map.size() > 2) {

                // Put the fruit at left and reduce its frequency
                map.put(fruits[left], map.get(fruits[left]) - 1);

                // If the frequency of the left pointer fruit is 0, remove it
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);

                // Increase the left pointer
                left++;
            }

            // Update the max length with current valid window
            maxlength = Math.max(maxlength, right - left + 1);

            // move the right pointer
            right++;
        }

        // Return max length as the final answer
        return maxlength;
    }
}
