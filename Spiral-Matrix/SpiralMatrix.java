import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Approach-1 -> Using the border shrinking technique
    public static List<Integer> generateMatrix(int matrix[][]) {
        int n = matrix[0].length, m = matrix.length;
        int top = 0, right = n - 1, bottom = m - 1, left = 0;

        List<Integer> answer = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // right
            for (int i = left; i <= right; i++)
                answer.add(matrix[top][i]);
            top++;

            // bottom
            for (int i = top; i <= bottom; i++)
                answer.add(matrix[i][right]);
            right--;

            // Check if the top is <= bottom first for right to left
            if (top <= bottom) {
                // left
                for (int i = right; i >= left; i--)
                    answer.add(matrix[bottom][i]);
                bottom--;
            }

            // Check if the left is <= right first for bottom to top
            if (left <= right) {
                // top
                for (int i = bottom; i >= top; i--)
                    answer.add(matrix[i][left]);
                left++;
            }
        }

        return answer;
    }

}
