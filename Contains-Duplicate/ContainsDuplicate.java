import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    // Approach-1 -> Using sorting to find if next element is same as current
    public boolean conatinsDuplicateSorting(int numbers[]) {

        // Sorting the array -> O(nlogn)
        Arrays.sort(numbers);

        // Array traversal for finding equality in next and previous -> O(n)
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] == numbers[i - 1])
                return true;

        return false;
    }

    // Approach-2 -> Using HashMap to map values and traverse it later
    public boolean containsDuplicateMap(int numbers[]) {

        // HashMap to store the values
        HashMap<Integer, Integer> map = new HashMap<>();

        // First traversal for mapping the values to its frequency -> O(n)
        for (int number : numbers)
            map.put(number, map.getOrDefault(number, 0) + 1);

        // Second traversal for traversing the values of map -> O(n)
        for (int value : map.values())
            if (value > 1)
                return true;

        return false;
    }

    // Approach-3 -> Using HashSet to eliminate duplicates
    public boolean containsDuplicateSet(int numbers[]) {

        // HashSet to store unique values
        HashSet<Integer> set = new HashSet<>();

        // Traversal of numbers and insertion into set -> O(n)
        for (int number : numbers)
            if (!set.add(number))
                return true;

        return false;
    }
}
