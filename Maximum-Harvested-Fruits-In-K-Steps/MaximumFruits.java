public class MaximumFruits {
    public int maxTotalFruits(int[][] fruits, int p, int k) {

        // Find the prefix sum of total fruits according to the positions
        int[] prefix = findPrefix(fruits);

        // Define max fruits to keep track of the maximum fruits
        int maxFruits = 0;

        // Traverse from 0 till k/2 distance to find valid distance that covers both
        // left and right and gives max fruits
        for (int d = 0; d <= k / 2; d++) {

            // Case-1 -> First go to left d steps
            int remain = k - 2 * d;
            int i = p - d;
            int j = p + remain;

            // Get the left and right positions
            int left = lowerBound(i, fruits);
            int right = upperBound(j, fruits) - 1;

            // Get the fruits and update with maximum
            if (left != -1 && right != -1 && left <= right) {
                int fruitsCollected = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
                maxFruits = Math.max(maxFruits, fruitsCollected);
            }

            // Case=2 -> First go to right d steps
            j = p + d;
            i = p - remain;

            // Get the left and right positions
            left = lowerBound(i, fruits);
            right = upperBound(j, fruits) - 1;

            // Get the fruits and update with maximum
            if (left != -1 && right != -1 && left <= right) {
                int fruitsCollected = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
                maxFruits = Math.max(maxFruits, fruitsCollected);
            }
        }

        // Return max fruits as the final answer
        return maxFruits;
    }

    // Find the prefix sum of fruits
    private int[] findPrefix(int[][] fruits) {

        // Find length of fruits
        int n = fruits.length;

        // Define result array to keep track of prefix
        int[] prefix = new int[n];

        // Iterate through fruits and find the prefix
        prefix[0] = fruits[0][1];

        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + fruits[i][1];

        // return prefix array as the final answer
        return prefix;
    }

    // Find lower bound of the given number
    private int lowerBound(int num, int[][] fruits) {

        // Define left and right
        int left = 0, right = fruits.length - 1;
        int answer = -1;

        while (left <= right) {

            // Calculate the mid
            int mid = (left + right) / 2;

            if (fruits[mid][0] >= num) {

                // Store the mid as potential answer
                answer = mid;

                // Go to the left side for finding first occurence
                right = mid - 1;
            }
            // If not, simply move to the right side
            else
                left = mid + 1;
        }

        // Return answer as the lower bound
        return answer;
    }

    // Find the upper bound of the given number
    private int upperBound(int num, int[][] fruits) {

        // Define left and right
        int left = 0, right = fruits.length - 1;
        int answer = fruits.length;

        while (left <= right) {

            // Calculate the mid
            int mid = (left + right) / 2;

            if (fruits[mid][0] > num) {

                // Store the mid as potential answer
                answer = mid;

                // Go to the left side for finding first occurence
                right = mid - 1;
            }
            // If not, simply move to the right side
            else
                left = mid + 1;
        }

        // Return answer as the lower bound
        return answer;
    }
}
