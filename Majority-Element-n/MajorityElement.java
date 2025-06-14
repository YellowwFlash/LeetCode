import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    // Approach-1 -> Using Extended Boyer Moore Voting algorithm
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, candidate1 = 0;
        int count2 = 0, candidate2 = 0;
        int n = nums.length;

        // Answer List
        List<Integer> answer = new ArrayList<>();

        // Traverse the list
        for (int num : nums) {

            // Init for candidate1
            if (count1 == 0 && candidate2 != num) {
                candidate1 = num;
                count1 = 1;
            }

            // Init for candidate2
            else if (count2 == 0 && candidate1 != num) {
                candidate2 = num;
                count2 = 1;
            }

            // Vote for candidate 1
            else if (candidate1 == num)
                count1 += 1;

            // Vote for candidate 2
            else if (candidate2 == num)
                count2 += 1;

            // Finally if there is nothing to vote, remove the votes
            else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        int check1 = 0, check2 = 0;
        for (int num : nums) {
            if (candidate1 == num)
                check1 += 1;
            if (candidate2 == num)
                check2 += 1;
        }

        int condition = (n / 3);

        if (check1 > condition)
            answer.add(candidate1);
        if (check2 > condition)
            answer.add(check2);

        return answer;
    }

}
