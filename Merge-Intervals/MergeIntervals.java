import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // Approach-1 -> Using sorting logic
    public static int[][] mergeIntervals(int intervals[][]) {

        // Result List
        List<int[]> result = new ArrayList<>();

        // Sort the array based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Start the traversal
        for (int interval[] : intervals)
            // If the result list is empty or the current interval does not overlap with the
            // last interval
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0])
                // No overlap just add the current interval
                result.add(interval);
            else
                // If the current interval overlaps with the last interval, merge them
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);

        // Conversion of list into a 2d array
        return result.toArray(new int[result.size()][]);
    }

}
