public class Sort {

    // Approach-1 -> Using the frequency technique
    public static void sort(int[] nums) {

        // A frequency array of size 3 for 0,1 and 2 as indices
        int frequencies[] = new int[3];

        for (int number : nums)
            // Increament the frequency of the number at its index
            frequencies[number]++;

        // Traverse the current array to sort it using frequency
        int index = 0;

        for (int i = 0; i < 3; i++)
            // Add the number frequency times to its array
            while (frequencies[i]-- > 0)
                nums[index++] = i;

    }

    // Approach-2 -> Using Dutch National Flag algorithm
    public static void sortDNFAlgo(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {

            // If mid is zero, swap it with low
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1)
                mid++;
            else {
                // If mid is 2, swap it with high
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int nums[], int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}