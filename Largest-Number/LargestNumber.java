import java.util.Arrays;

public class LargestNumber {

    // Approach-1 -> Using sorting approach and finding the largest combination
    public static int largestNumberSorting(int[] nums) {

        String[] numbers = new String[nums.length];
        int index = 0;

        // Get all the string values
        for (int number : nums)
            numbers[index++] = String.valueOf(number);

        // Sort the string array based on the logic
        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        // Merge the sorted biggest numbers into one
        String result = String.join("", numbers);

        // Return the final result converted into number
        return result.equals("0") ? 0 : Integer.parseInt(result);

    }
}
