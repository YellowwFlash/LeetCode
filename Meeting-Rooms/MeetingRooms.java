import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {

    // Pair class for reference of sorting
    static class Pair {
        int start;
        int end;
        int index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

    }

    // Approach-1 -> Using greedy sorting
    public List<Integer> meetingRooms(int[] start, int[] end) {

        // Find length of input array
        int n = start.length;

        // Define array of pairs
        Pair[] pairs = new Pair[n];

        // Insert start and end time in pairs
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(start[i], end[i], i);

        // Sort the pairs based on ending time
        Arrays.sort(pairs, (a, b) -> a.end - b.end);

        // Define free time and result list for storing the order of meetings
        int freeTime = 0;
        List<Integer> result = new ArrayList<>();

        // Iterate over pairs
        for (Pair pair : pairs) {

            // Get the start and end time of current meeting
            int startTime = pair.start, endTime = pair.end;

            // If the start time of current meeting is greater than equal to free time
            if (startTime >= freeTime) {
                // Perform the meeting and add its order in result
                result.add(pair.index + 1);
                // Update the free time to end time of current meeting
                freeTime = endTime;
            }

            // if not simply continue and skip the current meeting
        }

        // Return result list as the final order of maximum meetings
        return result;
    }
}