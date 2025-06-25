public class Beauty {

    // Approach-1 -> Using all substring and min max logic
    public static int beautyLoops(String s) {

        // Required variables
        int n = s.length(), result = 0;

        // String traversal
        for (int i = 0; i < n; i++) {

            // Frequency array for current substring frequency
            int[] freq = new int[26];

            // Finding the substring
            for (int j = i; j < n; j++) {
                char current = s.charAt(j);
                freq[current - 'a']++;

                // Keep the track of min and max frequency
                int max = 0, min = Integer.MAX_VALUE;

                for (int frequency : freq) {
                    if (frequency != 0) {
                        max = Math.max(max, frequency);
                        min = Math.min(min, frequency);
                    }
                }

                result += (max - min);
            }
        }

        return result;
    }
}