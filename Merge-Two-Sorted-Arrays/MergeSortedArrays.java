import java.util.Arrays;

public class MergeSortedArrays {

    // Approach-1 -> Using the element switching and sorting
    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;

        int end = n - 1, start = 0;

        // Iterate one array from start and one from end to swap
        while (end >= 0 && start < m) {
            // Check if the current element is worthy of sorting
            if (arr1[end] > arr2[start])
                // Swap the elements
                swap(arr1, arr2, end, start);

            end--;
            start++;
        }

        // Since all the worthy elements are now inplace. Sort them
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Approach-2 -> Using shell sort
    public static void mergeSortedArraysShellSort(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int length = n + m;
        int gap = (length / 2) + length % 2;

        while (gap > 0) {
            // Define the left and right pointers
            int left = 0;
            int right = left + gap;

            // Run loop until the left pointer is less than the length to cover whole arrays
            while (left < length) {

                // Case when left is in arr1 and right in arr2
                if (left < n && right >= n) {
                    int index = right - n;
                    if (arr1[left] > arr2[index])
                        swap(arr1, arr2, left, index);
                }

                // Case when left and right are in arr2
                else if (left >= n) {
                    int index1 = right - n, index2 = left - n;
                    if (arr2[left] > arr2[right])
                        swap(arr2, arr2, index2, index1);
                }

                // Case when left and right are in arr1
                else {
                    if (arr1[left] > arr1[right])
                        swap(arr1, arr1, left, right);
                }

                // Increase the left and right
                left++;
                right++;
            }

            // Increase the gap
            if (gap == 1)
                break;

            gap = (gap / 2) + (gap % 2);

        }
    }

    private static void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
