public class UnionTwoSortedArrays {

    // Approach-1 -> Using the simple merge-pointers logic
    public static int[] union(int num1[], int num2[]) {
        // Construct the result array
        int n = num1.length, m = num2.length;
        int result[] = new int[n + m];

        // Keep a pointer for each array
        int i = 0, j = 0, k = 0;

        // Iterate both of the arrays and merge them
        while (i < n && j < m) {

            // If both of them are the same numbers, insert it once and increment both
            if (num1[i] == num2[j]) {
                result[k++] = num1[i];
                i++;
                j++;
            }

            // If element at i is greater than element at j
            else if (num1[i] > num2[j]) {
                result[k++] = num2[j];
                j++;
            }

            // if element at j is greater than element at i
            else {
                result[k++] = num1[i];
                i++;
            }
        }

        // Add the remaining elements in the result array for both i and j indices
        while (i < n)
            result[k++] = num1[i++];

        while (j < m)
            result[k++] = num2[j++];

        return result;
    }
}
