import java.util.ArrayList;

public class CountInversions {

    // Approach-1 -> Using two loops
    public static int countInversionsLoops(int[] nums) {
        int inversions = 0;
        int n = nums.length;

        // External loop for all the elements
        for (int i = 0; i < n - 1; i++)
            // Internal loop to check if current element is less than external one
            for (int j = i + 1; j < n; j++)
                // If the external element is greater, there is an inversion possible
                if (nums[i] > nums[j]) // Here it is obvious that i is always lesser than j
                    inversions++;

        return inversions;
    }

    // Approach-2 -> Using the advanced merge sorting algo(Current array will be modified to sorted one)
    public static int countInversionsMergeSort(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        int inversions = 0;

        if (low >= high)
            return inversions;

        int mid = (low + high) / 2;

        inversions += mergeSort(nums, low, mid);
        inversions += mergeSort(nums, mid + 1, high);
        inversions += merge(nums, low, mid, high);
        return inversions;

    }

    private static int merge(int[] nums, int low, int mid, int high) {

        // Temporary arraylist
        ArrayList<Integer> list = new ArrayList<>();

        // Sorting essentials
        int left = low, right = mid + 1;

        int inversions = 0;

        // Start sorting
        while (left <= mid && right <= high) {

            // Left smaller element
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            }
            // Right smaller element
            else {
                list.add(nums[right]);

                // Adding the inversions from the current left element till the end
                inversions += (mid - left + 1);
                right++;
            }
        }

        // Remaining left elements
        while (left <= mid)
            list.add(nums[left++]);

        // Remaining right elements
        while (right <= high)
            list.add(nums[right++]);

        // Transfer all the elements to array
        for (int i = low; i <= high; i++)
            nums[i] = list.get(i - low);

        return inversions;
    }
}
