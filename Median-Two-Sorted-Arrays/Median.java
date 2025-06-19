public class Median {

    // Approach-1 -> Using extra space
    public double findMedianExtraSpace(int nums1[], int nums2[]) {

        int n1 = nums1.length, n2 = nums2.length;
        int m = n1 + n2;
        int i = 0, j = 0;

        // Make a new space for merging the arrays
        int[] merged = new int[m];
        int index = 0;

        while (i < n1 && j < n2) {

            // If element at i is less than j it goes first
            if (nums1[i] <= nums2[j])
                // Add the ith element to merged array
                merged[index++] = nums1[i++];

            // If not, then the jth element goes first
            else
                merged[index++] = nums2[j++];
        }

        // Check if the current total of lengths is odd or even
        if (m % 2 == 0) {
            // There will be two midpoints
            return (merged[m / 2 - 1] + merged[m / 2]) / 2.0;
        }

        // If not then simply return the midpoint
        return merged[m / 2];
    }

    // Approach-2 -> Using the simple pointer technique
    public double findMedianSimplePointer(int nums1[], int nums2[]) {

        int n1 = nums1.length, n2 = nums2.length;
        int m = n1 + n2;

        // The indexes and elements at the midpoints of both arrays
        int i1 = m / 2, i2 = i1 - 1, ele1 = 0, ele2 = 0;

        // The index for traversals
        int i = 0, j = 0, count = 0;

        // Start the traversal
        while (i < n1 && j < n2) {

            // Check for smaller of ith and jth element
            if (nums1[i] <= nums2[j]) {

                // Check if the current count is equal to any of the indices
                if (count == i1)
                    ele1 = nums1[i];
                if (count == i2)
                    ele2 = nums1[i];

                // Simply increase the count and the index
                count++;
                i++;
            }

            // For j as the smaller element
            else {
                // Check if the current count is equal to any of the indices
                if (count == i1)
                    ele1 = nums2[j];
                if (count == i2)
                    ele2 = nums2[j];

                // Simply increase the count and the index
                count++;
                j++;
            }
        }

        // Add the remaining elements
        while (i < n1) {
            // Check if the current count is equal to any of the indices
            if (count == i1)
                ele1 = nums1[i];
            if (count == i2)
                ele2 = nums1[i];

            // Simply increase the count and the index
            count++;
            i++;
        }

        while (j < n2) {
            // Check if the current count is equal to any of the indices
            if (count == i1)
                ele1 = nums2[j];
            if (count == i2)
                ele2 = nums2[j];

            // Simply increase the count and the index
            count++;
            j++;
        }

        // Check if the total number is even
        if (m % 2 == 0)
            // If even, add the two elements
            return ((double) ele1 + ele2 / 2.0);

        // If not then simply return the 1st element
        return ele1;
    }
}
