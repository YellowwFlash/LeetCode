import java.util.Arrays;
import java.util.HashMap;

public class MissingRepeating {
    // Approach-1 -> Using internal sorting to find repeating element
    public static int[] findRepeatingSorting(int[] numbers) {
        int n = numbers.length, actualSum = 0, repeatedNum = 0, missingNum = 0;
        int originalSum = n * (n + 1) / 2;

        // Traversal to find the actual sum with missing and repeated value
        for (int number : numbers)
            actualSum += number;

        // Sort the array to find the repeated number
        Arrays.sort(numbers);

        // Traversal to find same number adjacent to each other
        for (int i = 1; i < n; i++)
            if (numbers[i] == numbers[i - 1])
                repeatedNum = numbers[i];

        missingNum = Math.abs(originalSum - actualSum) + repeatedNum;

        return new int[] { repeatedNum, missingNum };
    }

    // Approach-2 -> Using HashMap to map the values for their frequency
    public static int[] findRepeatingHashMap(int[] numbers) {
        int n = numbers.length, actualSum = 0, repeatedNum = 0, missingNum = 0;
        int originalSum = n * (n + 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            actualSum += number;
            if (map.getOrDefault(number, 0) != 0)
                repeatedNum = number;
            else
                map.put(number, 1);
        }
        missingNum = Math.abs(originalSum - actualSum) + repeatedNum;

        return new int[] { repeatedNum, missingNum };
    }

    // Approach-3 -> Using mathematical Approach
    public static int[] findRepeatingMath(int[] numbers) {
        int n = numbers.length, actualSum = 0, repeatedNum = 0 /* x -> repeated num */,
                missingNum = 0 /* y -> missing number */, squaredSum = 0;
        int originalSum = n * (n + 1) / 2;
        int originalSquaredSum = n * (n + 1) * (2 * n + 1) / 6;

        // Traversal to find actual ans squared sum
        for (int number : numbers) {
            actualSum += number;
            squaredSum += number * number;
        }

        // first find x - y using actual sum
        int xMinusY = originalSum - actualSum;

        // find x + y using elimination of (x-y) in squared sum
        int xPlusY = originalSquaredSum - squaredSum;
        xPlusY = xPlusY / xMinusY;

        // Add both to get the repeated number
        repeatedNum = (xPlusY + xMinusY) / 2;

        // Get the missing number from sum equation
        missingNum = xPlusY - repeatedNum;

        return new int[] { repeatedNum, missingNum };
    }
}
