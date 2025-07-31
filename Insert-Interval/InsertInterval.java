import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    // Approach-1 -> Using the same logic as in merge intervals
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        // Find the length of intervals
        int n = intervals.length;

        // Define index to keep track of the intervals
        int i = 0;

        // Define a list to store the result
        List<int[]> result = new ArrayList<>();

        // Loop through the intervals and add the non overlapping intervals to result
        while (i < n && intervals[i][1] < newInterval[0]) {

            // Add the current interval in result
            result.add(intervals[i]);

            // Move the index
            i++;
        }

        // Loop through the intervals and add the overlapping intervals to result
        while (i < n && intervals[i][0] <= newInterval[1]) {

            // Update the newInterval start
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);

            // Update the newInterval end
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            // Move the index
            i++;
        }

        // Add the new interval in result
        result.add(newInterval);

        // Add the remaining intervals
        while (i < n)
            result.add(intervals[i++]);

        // Return the result after converting it to array
        return result.toArray(new int[result.size()][]);
    }
}
