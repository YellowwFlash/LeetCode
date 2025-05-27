public class NextPermutation {
    // Approach-1 -> Find all permutations and then search for just the next one of the given
    // Very slimy approach and takes O(n! + n) time to work out

    // Approach-2 -> Using breakpoint and reversing the array -> O(n)
    public static void nextPermutation(int[] nums) {
        int index = -1, n = nums.length;

        // Find the breakpoint index for anamoly
        for (int i = n - 2; i >= 0; i--) 
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        // If there is no breakpoint, just reverse the current permutation
        if (index == -1)
            reverse(nums, 0, n - 1);

        // Find the element just greater index element with anamoly to swap
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                // Swap the element at index with the greater element
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // Reverse the elements from index's next till the end to make the perm sorted
        reverse(nums, index + 1, n - 1);
    }

    public static void reverse(int[] nums, int start, int finish) {
        while (start < finish) {
            int temp = nums[start];
            nums[start++] = nums[finish];
            nums[finish--] = temp;
        }
    }

}
