public class ProductExceptSelf {

    // Approach-1 -> Using the prefix and suffix arrays
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n]; // result array
        int prefix[] = new int[n]; // To find all the prefix products except the element
        int suffix[] = new int[n]; // To find the suffix products except the element

        // Traversal for prefix
        prefix[0] = 1;
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        // Traversal for suffix
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        // Resultant product except self
        for (int i = 0; i < n; i++)
            result[i] = prefix[i] * suffix[i];

        return result;
    }

    // Approach-2 -> Using the same stretegy with no space
    public static int[] productExceptSelfNoSpace(int[] nums) {
        int n = nums.length;
        int result[] = new int[n]; // result array

        // Traversal for the prefix product
        result[0] = 1;
        for (int i = 1; i < n; i++)
            result[i] = result[i - 1] * nums[i - 1];

        // Traversal for the suffix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = nums[i];
        }

        return result;

    }
}
