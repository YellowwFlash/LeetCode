import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    // Variation-1 -> Using BFS(Check if all courses are possible or not)
    public static boolean isPossible(int numCourses, int[][] prerequisites) {

        // Find the length of prerequisites
        int n = prerequisites.length;

        // Define an adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Add all the courses in the graph
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // Define an indegree array to keep track of the indegrees
        int[] indegree = new int[numCourses];

        // Add the vertices in graph and indegree for each course
        for (int i = 0; i < n; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        // Define a queue to store the courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // Define a counter to check if all courses are possible or not
        int completed = 0;

        // Perform BFS
        while (!queue.isEmpty()) {

            // Get the current course
            int course = queue.poll();

            // Increment the counter of completed courses
            completed++;

            // Iterate over all the courses of the current course
            for (int nextCourse : graph.get(course)) {

                // If the indegree of nextCourse is non zero
                if (indegree[nextCourse] != 0) {
                    // Decrement the indegree of nextCourse
                    indegree[nextCourse]--;

                    // If the indegree of nextCourse is 0, add it to the queue
                    if (indegree[nextCourse] == 0)
                        queue.add(nextCourse);
                }
            }
        }

        // If all courses are possible, return true
        return completed == numCourses;
    }

    // Variation-2 -> Using BFS(Provide the order of taking all the courses)
    public static List<Integer> findOrder(int numCourses, int[][] prerequisites) {

        // Find the length of prerequisites
        int n = prerequisites.length;

        // Define an adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Add all the courses in the graph
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // Define an indegree array to keep track of the indegrees
        int[] indegree = new int[numCourses];

        // Add the vertices in graph and indegree for each course
        for (int i = 0; i < n; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        // Define a queue to store the courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // Define order list to keep track of the order
        List<Integer> order = new ArrayList<>();

        // Perform BFS
        while (!queue.isEmpty()) {

            // Get the current course
            int course = queue.poll();

            // Add the current course in order
            order.add(course);

            // Iterate over all the courses of the current course
            for (int nextCourse : graph.get(course)) {

                // If the indegree of nextCourse is non zero
                if (indegree[nextCourse] != 0) {
                    // Decrement the indegree of nextCourse
                    indegree[nextCourse]--;

                    // If the indegree of nextCourse is 0, add it to the queue
                    if (indegree[nextCourse] == 0)
                        queue.add(nextCourse);
                }
            }
        }

        // If all courses are possible, return true
        return order;
    }
}
