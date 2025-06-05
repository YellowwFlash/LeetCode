public class MoveZerosToEnd {

    // Approach-1 -> Using the indexing technique
    public static void moveZerosToEnd(int[] numbers) {

        int n = numbers.length;

        // An index for the manipulation of the numbers
        int index = 0;

        for (int number : numbers)
            // If the number is non zero, then the array must be manipulated
            if (number != 0)
                numbers[index++] = number;

        while (index < n)
            numbers[index++] = 0;
    }
}
