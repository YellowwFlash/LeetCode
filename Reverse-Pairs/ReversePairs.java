import java.util.ArrayList;

public class ReversePairs {

    // Approach-1 -> Using two loops
    public static int reversePairsLoops(int[] nums) {
        int pairs = 0;
        int n = nums.length;

        // External loop to find the first element
        for (int i = 0; i < n - 1; i++)
            // Internal loop to find the second element
            for (int j = i + 1; j < n; j++)
                // Check if the first element is twice the greater than the second element
                if ((long)nums[i] > 2L * nums[j])
                    pairs += 1;

        return pairs;
    }

    // Approach-2 -> Using the advanced merge sort algorithm
    public static int reversePairsMergeSort(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private static int merge(int[] nums, int low, int high) {
        int pairs = 0;
        if (low <= high)
            return pairs;

        int mid = (low + high) / 2;
        pairs += merge(nums, low, mid);
        pairs += merge(nums, mid + 1, high);
        pairs += countPairs(nums, low, mid, high);
        mergeSort(nums, low, mid, high);

        return pairs;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {
        int pairs = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)nums[i] > 2L * nums[right])
                right++;
            pairs += right - (mid + 1);
        }

        return pairs;
    }

    private static void mergeSort(int[] nums, int low, int mid, int high) {

        ArrayList<Integer> list = new ArrayList<>();

        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {

            // Left sorted
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            }
            // Right sorted
            else {
                list.add(nums[right]);
                right++;
            }
        }

        // Left reamaining elements
        while (left <= mid)
            list.add(nums[left++]);

        // Right remaining elements
        while (right <= high)
            list.add(nums[right++]);

        // Transfer elements to array
        for (int i = low; i <= high; i++)
            nums[i] = list.get(i - low);
    }

}
