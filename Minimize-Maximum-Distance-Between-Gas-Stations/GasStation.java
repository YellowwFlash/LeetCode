import java.util.PriorityQueue;

public class GasStation {

    // Approach-1 -> Using the linear scan method
    public static double minimizeGasStationDistanceLoop(int[] positions, int stations) {

        int n = positions.length;
        int howMany[] = new int[n - 1];

        // Start from a 1 till stations and check for the max distance in all the
        // stations
        for (int i = 1; i <= stations; i++) {

            // For each gas station, check the distance and validate it
            double maxSection = -1;
            int maxIndex = -1;

            for (int j = 0; j < n - 1; j++) {

                // Calculate the section for current index
                double section = positions[j + 1] - positions[j];
                // Calculate the section length
                double sectionLength = section / (howMany[i] + 1);

                if (sectionLength > maxSection) {
                    // Consider the max section to be the current section
                    maxSection = sectionLength;
                    // Set the max index to current station index
                    maxIndex = i;
                }
            }

            // After finding the reliable place, add the place of gas station
            howMany[maxIndex]++;
        }

        // Find the maximum distance
        double maxDistance = -1;
        for (int i = 0; i < n - 1; i++) {
            double section = positions[i + 1] - positions[i];
            double sectionLength = section / (howMany[i] + 1);

            maxDistance = Math.max(maxDistance, sectionLength);
        }

        return maxDistance;
    }

    // Approach-2 -> Using priority queue
    public class Pair {
        double distance;
        int index;

        Pair(double distance, int index) {
            this.distance = distance;
            this.index = index;
        }
    }

    public double minimizeGasStationDistancePQ(int positions[], int stations) {

        int n = positions.length;
        int howMany[] = new int[n - 1];

        // Make a priority queue with pair as datatype
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));

        // First store all the distances along with index into it
        for (int i = 0; i < n - 1; i++)
            pq.add(new Pair(positions[i + 1] - positions[i], i));

        // Start with finding the best for each gas station
        for (int i = 1; i <= stations; i++) {

            // Get the highest pair
            Pair pair = pq.poll();
            int index = pair.index;

            // insert the current gas station
            howMany[index]++;

            // Add new section and distance
            double section = positions[index + 1] - positions[index];
            double sectionLength = section / ((double) howMany[index] + 1);

            // Add it to priority queue
            pq.add(new Pair(sectionLength, index));
        }

        // Finally return the largest number of distance
        return pq.peek().distance;
    }

    // Approach-3 -> Using binary search
    public double minimizeGasStationDistanceBS(int positions[], int stations) {

        int n = positions.length;
        double low = 0, high = 0;
        double limit = 1e-6;
        double answer = -1;

        // Find the max distance for high
        for (int i = 0; i < n - 1; i++)
            high = Math.max(high, positions[i + 1] - positions[i]);

        // Start the binary search
        while (high - low > limit) {

            // Find the mid
            double mid = low + (high - low) / 2.0;
            // Find the count of gas stations possible for mid
            int count = findGasStations(positions, stations, mid);

            // If the current count is greater than stations, go to right to increase
            // distance reducing stations
            if (count > stations)
                low = mid;

            // If not, then go to right to find the minimum possible
            else {
                // Store the current mid as possible answer
                answer = mid;
                // Go to left
                high = mid;
            }
        }

        return answer;
    }

    private int findGasStations(int[] positions, int stations, double distance) {

        int currentStations = 0, n = positions.length;

        // Start the linear iteration and find the possible stations for each
        for (int i = 0; i < n - 1; i++) {
            int betweenNumbers = (int) ((positions[i + 1] - positions[i]) / distance);

            // Check for exact divisibility
            if (betweenNumbers * distance == positions[i + 1] - positions[i]) {
                betweenNumbers--;
            }

            currentStations += betweenNumbers;
        }

        return currentStations;
    }
}
