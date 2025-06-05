public class RotateArrayByK {

    // Approach-1 -> Using reversal algorithm
    public static void rotateArrayByK(int[] numbers, int k) {
        int n = numbers.length;

        // If the value of k is greater than the numbers' length
        k = k % n;

        // First reverse the whole array
        reverseArray(numbers, 0, n - 1);

        // Secondly, reverse the array from start until the n-k-1 th index
        reverseArray(numbers, 0, n - k - 1);

        // Finally, reverse the array from n-k to end index
        reverseArray(numbers, n - k, n - 1);
    }

    private static void reverseArray(int[] numbers, int start, int end) {
        while (start < end) {
            // Swap the start and end
            int temp = numbers[start];
            numbers[start++] = numbers[end];
            numbers[end--] = temp;
        }
    }
}
