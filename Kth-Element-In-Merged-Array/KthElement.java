public class KthElement {

    // Approach-1 -> Using extra space
    public static int findKthElementExtraSpace(int[] nums1, int[] nums2, int k) {

        // Find the lengths and define a new merged space
        int n1 = nums1.length, n2 = nums2.length;

        int[] merged = new int[n1 + n2];
        int index = 0;

        int i = 0, j = 0;

        // Merge both the arrays
        while (i < n1 && j < n2) {

            // Check for element at i smaller than j
            if (nums1[i] <= nums2[j])
                merged[index++] = nums1[i++];

            // If not then go for jth element
            else
                merged[index++] = nums2[j++];
        }

        // Add the reamining elements
        while (i < n1)
            merged[index++] = nums1[i++];

        while (j < n2)
            merged[index++] = nums2[j++];

        // Simply return the k-1 th index element of merged for kth element
        return merged[k - 1];
    }

    // Approach-2 -> Using the pointer technique
    public static int findKthElementPointer(int[] nums1, int[] nums2, int k) {

        int n1 = nums1.length, n2 = nums2.length;

        int i = 0, j = 0, count = 0;

        while (i < n1 && j < n2) {

            // Check for element at i smaller than j
            if (nums1[i] <= nums2[j]) {
                // Check if count is equal to k, return the current element
                if (count == k-1)
                    return nums1[i];

                // Increase the count and index
                count++;
                i++;
            }

            // if not, go for the jth element
            else {
                // Check if count is equal to k, return the current element
                if (count == k-1)
                    return nums2[j];

                // Increase the count and index
                count++;
                j++;
            }
        }

        // Add the reamining elements
        while (i < n1) {
            // Check if count is equal to k, return the current element
            if (count == k-1)
                return nums1[i];

            // Increase the count and index
            count++;
            i++;
        }

        while (j < n2) {
            // Check if count is equal to k, return the current element
            if (count == k-1)
                return nums2[j];

            // Increase the count and index
            count++;
            j++;
        }

        return -1;
    }
}
