import java.util.ArrayList;

public class AlternateNumbers {

    // Approach-1 -> Using the two pointers approach with seprate lists
    public static void alternateNumbers(int[] nums) {
        int n = nums.length;

        // Create seprate arraylists for +ve and -ve numbers
        ArrayList<Integer> negatives = new ArrayList<>();
        ArrayList<Integer> positives = new ArrayList<>();

        // Traverse the current numbers and part them in arraylist
        for (int num : nums)
            if (num < 0)
                negatives.add(num);
            else
                positives.add(num);

        // Start from index 0 and then add all the numbers to the array
        int posIndex = 0, negIndex = 1, index = 0;

        while (posIndex < n && negIndex < n) {
            nums[posIndex] = positives.get(index);
            nums[negIndex] = negatives.get(index++);
            posIndex += 2;
            negIndex += 2;
        }
    }

    // Approach-2 -> Using another array
    public static int[] alternateNumbersOptimized(int[] nums) {
        int n = nums.length;

        // Create a new array
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int num : nums) {
            if (num < 0) {
                result[negIndex] = num;
                negIndex += 2;
            } else {
                result[posIndex] = num;
                posIndex += 2;
            }
        }

        return result;
    }
}
