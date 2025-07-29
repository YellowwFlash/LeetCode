import java.util.Arrays;

public class AssignCookies {

    // Approach-1 -> Greedy Approach
    public static int findContentChildren(int[] greeds, int[] sizes) {

        // Sort both of the arrays
        Arrays.sort(greeds);
        Arrays.sort(sizes);

        // Find the sizes of both arrays
        int n = greeds.length, m = sizes.length;

        // Initialize two pointers
        int i = 0, j = 0;

        int answer = 0;

        // Iterate over the sizes array
        while (i < n && j < m) {
            int greed = greeds[i];
            int size = sizes[j];

            // If size >= greed then we can give the cookie to the child
            if (size >= greed) {
                answer++;
                i++;
                j++;
            } else {
                // Else we will move to the next size
                j++;
            }
        }

        // Return answer as then final answer
        return answer;
    }
}