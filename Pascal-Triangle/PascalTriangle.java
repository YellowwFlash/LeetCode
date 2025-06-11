import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // Approach-1 -> Using general approach
    public static void printPascalTriangle(int n) {

        // Hardcoded test case for n < 3
        if (n < 1)
            return;
        if (n < 2) {
            System.out.println(1);
            return;
        }

        // Make a list which stores all the rows of pascal triangle
        List<int[]> list = new ArrayList<>();

        // Add the first and second iteration of pascal triangle
        list.add(new int[] { 1 }); // first iteration
        list.add(new int[] { 1, 1 }); // second iteration

        // Starting with third iteration
        for (int i = 2; i < n; i++) {

            // Construct an array for current row
            int[] row = new int[i + 1];
            // First and last element will always be 1
            row[0] = row[row.length - 1] = 1;

            // Iterate the last iteration to find the current one
            int prev[] = list.get(list.size() - 1);
            int len = prev.length;

            // Start with the 2nd col till the len-1 th col for current iteration
            for (int j = 1; j < len; j++)
                // Add the current and prev col of prev to match the current row's current value
                row[j] = prev[j - 1] + prev[j];

            // Finally push the current row as the new row in result
            list.add(row);
        }

        // Print the final result
        for (int[] row : list) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Approach-2 -> Using the mathematical approach
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // inserting the 1st element

        // calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }
}
