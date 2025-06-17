public class SearchRotatedSorted {

    // Approach-1 -> Using simple linear seach -> O(n)
    public static int searchRotatedSortedLS(int[] numbers, int target) {

        // Linear traversal of numbers
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == target)
                return i;

        return -1;
    }

    // Approach-2 -> Using advanced binary seach and elimination -> O(logn)
    public static int searchSortedRotatedBS(int numbers[], int target) {

        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target)
                return mid;

            // Left array is sorted
            if (numbers[left] <= numbers[mid])
                // Target lies in the left sorted portion
                if (target < numbers[mid] && target >= numbers[left])
                    right = mid - 1;
                else
                    // Target lies in the right unsorted portion
                    left = mid + 1;

            // Right array is sorted
            else if (target > numbers[mid] && target <= numbers[right])
                // Target lies in the right sorted portion
                left = mid + 1;
            else
                // Ṭarget lies in the left unsorted portion
                right = mid - 1;

        }

        return -1;
    }

    // Approach-3 -> Using shrink space concept for duplicates
    public static boolean searchRotatedSortedSS(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            // Calculate the mid
            int mid = left + (right - left) / 2;

            // If the mid == target, return true
            if (numbers[mid] == target)
                return true;

            // In this case sorted part can't be determined, hence shrink the search space
            else if (numbers[mid] == numbers[left] && numbers[left] == numbers[right]) {
                left++;
                right--;
            }

            // Left sorted array
            else if (numbers[left] <= numbers[mid]) {
                // Check if target lies in the left sorted portion
                if (numbers[left] <= target && target < numbers[mid])
                    right = mid - 1;

                // If not, then go to the right unsorted portion
                else
                    left = mid + 1;
            }

            // Right sorted array
            else {
                // Check if target lies in the right sorted portion
                if (numbers[mid] < target && numbers[right] >= target)
                    left = mid + 1;

                // If not, then go to left unsorted portion
                else
                    right = mid - 1;
            }
        }

        return false;
    }
}