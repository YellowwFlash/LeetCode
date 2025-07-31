import java.util.Arrays;

public class NonOverlappingIntervals {

    // Appraoch-1 -> Using same logic as "N meetings in one room" problem
    public static int nonOverlappingIntervals(int[][] intervals) {

        // Find the length of the intervals array
        int n = intervals.length;

        // Sort the intervals based on the end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Keep count of the valid intervals
        int count = 0;

        // Keep track of the current end time
        int end = Integer.MIN_VALUE;

        // Iterate through the intervals
        for (int[] interval : intervals) {

            if (interval[0] >= end) {
                end = interval[1];
                count++;
            }
        }
        
        // Return the difference of count and intervals for non overlapping intervals
        return n - count;
    }
}
