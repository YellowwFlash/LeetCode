import java.util.Arrays;

public class MissingNumber {

    // Approach-1 -> Using internal sorting
    public static int findMissingNumberSorting(int[] nums) {

        int n = nums.length;

        // Sort the array for indexing
        Arrays.sort(nums);

        // Traversal for the missing index/number
        for (int i = 0; i < n; i++)
            if (nums[i] != i)
                return i;

        return n;
    }

    // Approach-2 -> Using summation logic
    public static int findMissingNumberSummation(int[] nums) {
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        // Traversal for summation of the given numbers
        for (int number : nums)
            actualSum += number;

        return totalSum - actualSum;
    }
}