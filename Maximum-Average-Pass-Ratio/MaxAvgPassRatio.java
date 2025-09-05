import java.util.PriorityQueue;

public class MaxAvgPassRatio {

    // Define a class to store the gain of avg pass ratio and index of the class
    public static class Pair {
        int pass, total;

        Pair(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        // Get the current ratio
        double ratio() {
            return (double) pass / total;
        }

        // Find the current gain
        double gain() {
            return (double) ((double) (pass + 1) / (total + 1)) - ratio();
        }
    }

    // Approach-1 -> Greedy approach (extra resources)
    public static double maxAvgPassRatio(int[][] classes, int extraStudents) {

        // Define a double variable to store the max avg pass ratio
        double maxAvgPassRatio = 0.0;

        // Define a max heap to store all the students
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.gain(), a.gain()));

        // Insert all the students in the max heap
        for (int[] studentClass : classes)
            maxHeap.add(new Pair(studentClass[0], studentClass[1]));

        // Iterate over the extra students
        while (extraStudents-- > 0) {

            // Get the student with the highest gain
            Pair student = maxHeap.poll();

            // Increase the pass and total of the student
            student.pass++;
            student.total++;

            // Add the student back to the max heap
            maxHeap.add(student);
        }

        // Compute the final avg pass ratio
        for (Pair student : maxHeap)
            maxAvgPassRatio = student.ratio();

        // Return the max avg pass ratio
        return maxAvgPassRatio;
    }
}
