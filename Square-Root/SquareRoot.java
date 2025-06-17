public class SquareRoot {

    // Approach-1 -> Using inbuilt function
    public static int findSquareRoot(int number) {
        return (int) Math.sqrt(number);
    }

    // Approach-2 -> Using linear search
    public static int findSquareRootLinearSearch(int number) {
        int root = -1;

        // Start from 1 till number/2 and scan each one
        for (int i = 1; i <= number / 2; i++)
            // For every iteration, if i*i is <= number
            if (i * i <= number)
                root = i;

        return root;
    }

    // Approach-3 -> Using binary search
    public static int findSquareRootBinarySearch(int number) {

        int root = -1;
        // Check for the number < 2
        if (number < 2)
            return number;

        // Define the search space
        int low = 1, high = number / 2;

        // Standard binary search
        while (low <= high) {

            // Calculate the mid
            int mid = low + (high - low) / 2;
            long num = (long) mid * (long) mid;

            // Check if mid is the root
            if (num == number) {
                root = mid;
                break;
            }
            // Else if check for the floor value on right
            else if (num < number) {
                root = mid;
                low = mid + 1; // Move to the right half
            }

            // If not, then find floor value on left
            else 
                high = mid - 1; // Move to the left half
        }

        return root;
    }
}
