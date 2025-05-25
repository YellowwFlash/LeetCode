import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    // Approach-1 -> Using sorting algos and streams
    public static void reverseArraySorted(int[] arr) {

        // Conversion of int[] to Integer[] 
        Integer[] temporary = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sorting the Integer[] using Collections
        Arrays.sort(temporary, Collections.reverseOrder());

        // Conversion of Integer[] back into int[] 
        int[] result = Arrays.stream(temporary).mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < arr.length; i++)
            arr[i] = result[i];
    }

    // Approach-2 -> Using two pointers technique
    public static void reverseArrayTwoPointers(int[] arr) {
        int left = 0, right = arr.length - 1;

        // Only half of the array is being traversed -> O(n/2) => O(n)
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

}
