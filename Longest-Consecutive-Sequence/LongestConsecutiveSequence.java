import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Approach-1 -> Using the set and start sequence logic
    public static int longestConsecutive(int[] nums) {
        int longest = 1;

        // Make a set and remove the duplicates
        HashSet<Integer> set = new HashSet<>();

        // Add all the numbers to set
        for (int num : nums)
            set.add(num);

        // Traverse the set to find the sequence

        for (int num : set) {

            // If the current number is start of the sequence
            if (!set.contains(num - 1)) {
                int count = 1, x = num;

                // Loop till the sequence goes ahead
                while (set.contains(x + 1)) {
                    x += 1;
                    count += 1;
                }

                // Update the longest sequence
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}
