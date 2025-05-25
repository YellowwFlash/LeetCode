import java.util.Arrays;

public class MinMax {

    // Approach-1 -> Using internal sorting -> O(nlogn)
    public int[] findMinMaxSorted(int numbers[]) {
        int result[] = new int[2];

        Arrays.sort(numbers); // O(nlogn)
        result[0] = numbers[0]; // O(1) -> Minimum element
        result[1] = numbers[numbers.length - 1]; // O(1) -> Maximum element

        return result;
    }

    // Approach-2 -> Without using any internal methods -> O(n)
    public int[] findMinMaxUnsorted(int numbers[]) {
        int result[] = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return result;
    }
}
