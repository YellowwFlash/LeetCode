public class MaximumProductSubarray {

    // Approach-1 -> Using the prefix-suffix fundamental
    public static int maxProductSubarray(int[] nums) {
        int n = nums.length;
        int prefix = 1, suffix = 1, max = Integer.MIN_VALUE;

        // Traverse the array with forward and backward products
        for (int i = 0; i < n; i++) {
            // For every encountered 0, turn the prefix or suffix to 1 to change the product
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - i - 1]; // Backward product
            max = Math.max(max, Math.max(prefix, suffix)); //Update the max product
        }
        return max;
    }
}