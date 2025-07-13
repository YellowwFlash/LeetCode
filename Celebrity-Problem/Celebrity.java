public class Celebrity {

    // Approach-1 -> Using the iKnow uKnow array
    public static int celebrity(int[][] M, int n) {
        int[] iKnow = new int[n];
        int[] uKnow = new int[n];

        // Fill the iKnow and uKnow arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    iKnow[i]++;
                    uKnow[j]++;
                }
            }
        }

        // Find the celebrity
        for (int i = 0; i < n; i++) {
            if (iKnow[i] == 0 && uKnow[i] == n - 1) {
                return i;
            }
        }

        return -1; // No celebrity found
    }

    // Approach-2 -> Using the top and down pointers
    public static int celebrityPointers(int[][] M, int n) {

        // Define top and down pointers
        int top = 0, down = n - 1;

        // Traverse until top and down meet
        while (top < down) {

            // If top knows down, then top cannot be a celebrity
            if (M[top][down] == 1)
                top++;

            // If top doesnt know down, then down cannot be a celebrity
            else
                down--;
        }

        // Check if the candidate is a celebrity
        if (top > down)
            return -1;

        // Verify the candidate
        for (

                int i = 0; i < n; i++) {
            if (i != top && (M[top][i] == 1 || M[i][top] == 0)) {
                return -1; // Not a celebrity
            }
        }

        return top; // Found the celebrity
    }
}
